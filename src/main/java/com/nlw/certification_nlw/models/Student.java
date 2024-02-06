package com.nlw.certification_nlw.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private UUID id;
    private String email;
    private List<Certification> certification;
}
