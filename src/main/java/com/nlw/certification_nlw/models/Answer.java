package com.nlw.certification_nlw.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private UUID id;
    private UUID studentID;
    private UUID certificationID;
    private UUID questionID;
    private UUID answerID;
    private boolean isCorrect;


}
