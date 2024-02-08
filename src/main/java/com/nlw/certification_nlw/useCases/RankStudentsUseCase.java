package com.nlw.certification_nlw.useCases;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.models.Certification;
import com.nlw.certification_nlw.repositories.HasCertificationRepository;
import com.nlw.certification_nlw.repositories.RankStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankStudentsUseCase {
    @Autowired
    private RankStudentsRepository rankStudentsRepository;

    public List<Certification> execute() {
        return this.rankStudentsRepository.getAllCertifiedStudents();
    }

}
