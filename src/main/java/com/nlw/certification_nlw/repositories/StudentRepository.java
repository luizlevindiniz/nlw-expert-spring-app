package com.nlw.certification_nlw.repositories;

import com.nlw.certification_nlw.models.Student;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Find
    Student findStudentByEmail(String email);


}
