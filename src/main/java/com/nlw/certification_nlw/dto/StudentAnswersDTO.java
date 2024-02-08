package com.nlw.certification_nlw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentAnswersDTO {
    private String email;
    private String tech;
    List<QuestionsAndAnswersDTO> listOfQuestionsAndAnswers;
}
