package com.example.projectoftest.service;

import com.example.projectoftest.dto.DoctorDTO;
import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.entities.Doctor;
import com.example.projectoftest.entities.Patient;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.DoctorRepository;
import com.example.projectoftest.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TransactionService {

    CardRepository cardRepository;
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;

    @Transactional
    public Boolean tran(PatientDto patientDto, DoctorDTO doctorDTO, Double gettingBalance){
            Patient patient =  patientRepository.getReferenceById(patientDto.getId());
            Doctor doctor = doctorRepository.getReferenceById(doctorDTO.getId());
        Card patientCard = patient.getCards().stream().filter(Card::getActive).findFirst().get();
        Card doctorCard = doctor.getCards().stream().filter(Card::getActive).findFirst().get();
        if (patientCard.getBalance()>gettingBalance){
            double v = patientCard.getBalance() - gettingBalance;
            double v1 = doctorCard.getBalance() + v;
            doctorCard.setBalance(v1);
            return true;
        }
        return false;
    }


}
