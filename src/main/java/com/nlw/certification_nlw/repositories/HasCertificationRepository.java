package com.nlw.certification_nlw.repositories;

import com.nlw.certification_nlw.models.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface HasCertificationRepository extends JpaRepository<Certification, UUID> {
    @Query("SELECT c from certifications c INNER join c.student std where std.email = :email and c.tech = :tech")
    List<Certification> findByStudentEmailAndTech(String email, String tech);
}
