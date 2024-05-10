package com.example.projectoftest.service;

import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.entities.Patient;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientDto savePatient(PatientDto dto){
        Patient Patient = mapToEntity(dto);
        patientRepository.save(Patient);
        return mapToDto(Patient);
    }
    public Patient mapToEntity(PatientDto dto){
        return Patient.builder()
                .name(dto.getName())
                .build();
    }

    private PatientDto mapToDto(Patient Patient){
        return PatientDto.builder()
                .id(Patient.getId())
                .name(Patient.getName())
                .cardsId(Patient.getCards()
                        .stream()
                        .map(Card::getId)
                        .collect(toList()))
                .build();
    }

}
