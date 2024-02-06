package com.nlw.certification_nlw.controllers;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import com.nlw.certification_nlw.useCases.HasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private HasCertificationUseCase hasCertificationUseCase;

    @PostMapping("/certification")
    public String hasCertification(@RequestBody HasCertificationDTO body) {
        if(this.hasCertificationUseCase.execute(body)){
            return "Student already has this certification!";
        }
        return "Student does not have this certification yet!";
    }
}
