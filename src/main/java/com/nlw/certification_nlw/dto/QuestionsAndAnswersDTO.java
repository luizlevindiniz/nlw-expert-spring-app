package com.nlw.certification_nlw.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionsAndAnswersDTO {
    private UUID questionID;
    private UUID alternativeID;
    private boolean isCorrectAlternative;

}
