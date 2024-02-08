package com.nlw.certification_nlw.controllers;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.dto.StudentAnswersDTO;
import com.nlw.certification_nlw.models.Certification;
import com.nlw.certification_nlw.useCases.HasCertificationUseCase;
import com.nlw.certification_nlw.useCases.StudentQuestionsAndAnswersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private HasCertificationUseCase hasCertificationUseCase;
    @Autowired
    private StudentQuestionsAndAnswersUseCase studentQuestionsAndAnswersUseCase;

    @PostMapping("/certification")
    public String hasCertification(@RequestBody HasCertificationDTO body) {
        if(this.hasCertificationUseCase.execute(body)){
            return "Student already has this certification!";
        }
        return "Student does not have this certification yet!";
    }
    @PostMapping("/answers")
    public ResponseEntity<Object> checkStudentAnswers(@RequestBody StudentAnswersDTO studentAnswers) {
        try {
            Certification result = this.studentQuestionsAndAnswersUseCase.studentQuestionsAndAnswers(studentAnswers);
            return ResponseEntity.ok().body(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
