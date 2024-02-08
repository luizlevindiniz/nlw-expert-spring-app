package com.nlw.certification_nlw.controllers;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.dto.StudentAnswersDTO;
import com.nlw.certification_nlw.models.Certification;
import com.nlw.certification_nlw.useCases.HasCertificationUseCase;
import com.nlw.certification_nlw.useCases.RankStudentsUseCase;
import com.nlw.certification_nlw.useCases.StudentQuestionsAndAnswersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankStudentsUseCase rankStudentsUseCase;

    @GetMapping("/top")
    public List<Certification> rankStudents() {
        return rankStudentsUseCase.execute();
    }

}
