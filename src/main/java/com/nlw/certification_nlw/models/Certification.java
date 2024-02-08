package com.nlw.certification_nlw.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
@Builder
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String tech;

    @Column(length = 10)
    private int grade;

    @Column(name = "student_id")
    private UUID studentID; // FK

    @ManyToOne
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "certification_id",insertable = false,updatable = false)
    @JsonManagedReference
    private List<Answer> answers;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
