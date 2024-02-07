package com.nlw.certification_nlw.useCases;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.models.Certification;
import com.nlw.certification_nlw.repositories.HasCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HasCertificationUseCase {

    @Autowired
    private HasCertificationRepository hasCertificationRepository;

    public boolean execute(HasCertificationDTO dto) {
        List<Certification> certificationList = this.hasCertificationRepository.findByStudentEmailAndTech
                (dto.getEmail(), dto.getTech());
        return !certificationList.isEmpty();
    }
}
