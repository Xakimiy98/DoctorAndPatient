package com.example.projectoftest.service;

import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.entities.Click;
import com.example.projectoftest.entities.Patient;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TransactionService {
    private final Click click;
    private final CardRepository cardRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public boolean tran(PatientDto patientDto, CardDto cardDto, Double gettingBalance){
            Patient patient =  patientRepository.getReferenceById(patientDto.getId());
            Card card =  cardRepository.getReferenceById(cardDto.getId());

        if (patient.getCards().stream().anyMatch(e -> e.getId().equals(card.getId()))){
            double v = gettingBalance * click.getPatientKomisya();
            click.setBalance(click.getBalance()+v);
            card.setBalance(card.getBalance()+(gettingBalance-v));
            return true;
        }else if (patient.getCards().stream().noneMatch(e -> e.getId().equals(card.getId()))){
            double v = gettingBalance * click.getKomisya();
            click.setBalance(click.getBalance()+v);
            card.setBalance(card.getBalance()+(gettingBalance-v));
            return true;
        }
        return false;
    }
}
