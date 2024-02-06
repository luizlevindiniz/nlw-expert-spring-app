package com.nlw.certification_nlw.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Certification {
    private UUID studentID; //FK
    private UUID id;
    private String tech;
    private int grade;
    private List<Answer> answers;

}
