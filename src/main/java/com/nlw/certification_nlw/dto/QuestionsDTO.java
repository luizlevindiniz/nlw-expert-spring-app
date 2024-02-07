package com.nlw.certification_nlw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionsDTO {
    private UUID id;
    private String description;
    private List<AlternativesDTO> alternatives;
}
