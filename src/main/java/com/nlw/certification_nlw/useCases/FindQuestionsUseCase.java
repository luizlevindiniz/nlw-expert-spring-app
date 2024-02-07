package com.nlw.certification_nlw.useCases;

import com.nlw.certification_nlw.dto.FindQuestionsByDTO;
import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.models.Certification;
import com.nlw.certification_nlw.models.Question;
import com.nlw.certification_nlw.repositories.FindQuestionsByRepository;
import com.nlw.certification_nlw.repositories.HasCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindQuestionsUseCase {

    @Autowired
    private FindQuestionsByRepository findQuestionsByRepository;

    public List<Question> execute(FindQuestionsByDTO technology) {
        return this.findQuestionsByRepository.findQuestionsByTech(technology.getTechnology());
    }
}
