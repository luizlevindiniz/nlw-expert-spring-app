package com.nlw.certification_nlw.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "tech", length = 50)
    private String tech;

    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Alternative> alternatives;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
