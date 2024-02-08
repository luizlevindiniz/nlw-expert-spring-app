package com.nlw.certification_nlw.useCases;

import com.nlw.certification_nlw.dto.QuestionsAndAnswersDTO;
import com.nlw.certification_nlw.dto.StudentAnswersDTO;
import com.nlw.certification_nlw.models.*;
import com.nlw.certification_nlw.repositories.FindQuestionsByRepository;
import com.nlw.certification_nlw.repositories.HasCertificationRepository;
import com.nlw.certification_nlw.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentQuestionsAndAnswersUseCase {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private HasCertificationRepository hasCertificationRepository;

    @Autowired
    private FindQuestionsByRepository findQuestionsByRepository;

    

    public Certification studentQuestionsAndAnswers(StudentAnswersDTO dto) throws RuntimeException {

        if(!hasCertificationRepository.findByStudentEmailAndTech(dto.getEmail(), dto.getTech()).isEmpty()){
            throw new RuntimeException("Student already has this certification!");
        }

        Optional<Student> student = Optional.ofNullable(studentRepository.findStudentByEmail(dto.getEmail()));

        // if not found then create student
        UUID studentId;
        if (student.isEmpty()) {
        Student newStudent = Student.builder().email(dto.getEmail())
                .certification(new ArrayList<>())
                .build();
        newStudent = studentRepository.save(newStudent);
        studentId = newStudent.getId();
        } else {
            studentId = student.get().getId();
        }

        List<Question> questionsList = findQuestionsByRepository.findQuestionsByTech(dto.getTech());
        // creating student`s list of answers
        List<Answer> studentGroupOfAnswers = new ArrayList<>();

        List<QuestionsAndAnswersDTO> studentQuestionsAndAnswers = dto.getListOfQuestionsAndAnswers();

        AtomicInteger studentGradeCounter = new AtomicInteger(0);

        studentQuestionsAndAnswers.forEach(studentQAndA -> {
            Optional<Question> questionToCheckAnswer = questionsList.stream()
                    .filter(question -> question.getId().equals(studentQAndA.getQuestionID()))
                    .findFirst();

            if (questionToCheckAnswer.isEmpty()) {
                throw new RuntimeException("Question not found!");
            }

            Optional<Alternative> filteredAlternative = questionToCheckAnswer.get()
                    .getAlternatives().stream()
                    .filter((Alternative::isCorrect)).findFirst();

            if (filteredAlternative.isPresent()) {
                Alternative correctAlternative = filteredAlternative.get();

                if(correctAlternative.getId()
                        .equals(studentQAndA.getAlternativeID())){
                    studentQAndA.setCorrectAlternative(true);
                    studentGradeCounter.getAndIncrement();
                } else{
                    studentQAndA.setCorrectAlternative(false);
                }

            } else {
                throw new RuntimeException("Alternative not found!");
            }

            Answer answer = Answer.builder().answerID(studentQAndA.getQuestionID())
                    .questionID(studentQAndA.getAlternativeID()).isCorrect(studentQAndA.isCorrectAlternative())
                    .build();

            studentGroupOfAnswers.add(answer);

        });

        // creating student`s certification
        Certification studentCertification = Certification.builder().studentID(studentId)
                .tech(dto.getTech()).grade(studentGradeCounter.get()).build();

        Certification createdStudentCertification = hasCertificationRepository.save(studentCertification);

        studentGroupOfAnswers.forEach(answer -> {
            answer.setCertificationID(studentCertification.getId());
            answer.setCertification(studentCertification);
        });

        studentCertification.setAnswers(studentGroupOfAnswers);
        hasCertificationRepository.save(studentCertification);

        return createdStudentCertification;
    }
}
