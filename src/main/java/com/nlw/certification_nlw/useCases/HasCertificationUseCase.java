package com.nlw.certification_nlw.useCases;

import com.nlw.certification_nlw.dto.HasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class HasCertificationUseCase {
    public boolean execute(HasCertificationDTO dto){
        return dto.getEmail().equals("luizd97@gmail.com") && dto.getTech().equals("Javao");
    }
}
