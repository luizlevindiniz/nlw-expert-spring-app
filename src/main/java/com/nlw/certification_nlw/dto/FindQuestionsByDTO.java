package com.nlw.certification_nlw.dto;
import com.nlw.certification_nlw.models.Alternative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindQuestionsByDTO {
    private String technology;
}
