package com.nlw.certification_nlw.repositories;
import com.nlw.certification_nlw.models.Question;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FindQuestionsByRepository extends JpaRepository<Question, UUID> {
    @Find
    List<Question> findQuestionsByTech(String tech);
}
