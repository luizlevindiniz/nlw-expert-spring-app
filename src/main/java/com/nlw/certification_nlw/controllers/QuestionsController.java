package com.nlw.certification_nlw.controllers;


import com.nlw.certification_nlw.dto.AlternativesDTO;
import com.nlw.certification_nlw.dto.FindQuestionsByDTO;
import com.nlw.certification_nlw.dto.QuestionsDTO;
import com.nlw.certification_nlw.models.Alternative;
import com.nlw.certification_nlw.models.Question;
import com.nlw.certification_nlw.useCases.FindQuestionsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private FindQuestionsUseCase findQuestionsUseCase;


    @GetMapping("/tech/{technology}")
    public List<QuestionsDTO> findQuestionByTech(@PathVariable FindQuestionsByDTO technology){
        List<Question> result = this.findQuestionsUseCase.execute(technology);

        return result.stream().map(QuestionsController::mapQuestionToDTO).toList();

    }

    private static QuestionsDTO mapQuestionToDTO(Question question){
        QuestionsDTO formattedQuestion = QuestionsDTO.builder().id(question.getId())
                .description(question.getDescription()).build();

        List<AlternativesDTO> formattedAlternatives = question.getAlternatives().stream()
                .map(QuestionsController::mapAlternativeToDTO).toList();

        formattedQuestion.setAlternatives(formattedAlternatives);

        return formattedQuestion;
    }

    private static AlternativesDTO mapAlternativeToDTO(Alternative alternative){

        return AlternativesDTO.builder().id(alternative.getId())
                .description(alternative.getDescription())
                .build();
    }

}
