package com.nlw.certification_nlw.repositories;

import com.nlw.certification_nlw.models.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RankStudentsRepository extends JpaRepository<Certification, UUID> {

    @Query("SELECT c from certifications c inner join c.student std order by c.grade desc ")
    List<Certification> getAllCertifiedStudents();

}

