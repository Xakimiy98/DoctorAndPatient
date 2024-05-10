package com.example.projectoftest.service;
import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final PatientRepository patientRepository;

    public CardDto saveCard(CardDto dto){
        Card card = mapToEntity(dto);
        cardRepository.save(card);
        patientRepository.getReferenceById(dto.getPatientId()).getCards().add(card);
        return mapToDto(card);
    }

    public Card mapToEntity(CardDto dto){
        return Card.builder()
                .cardNumber(dto.getCardNumber())
                .patient(patientRepository.getReferenceById(dto.getPatientId()))
                .balance(dto.getBalance())
                .build();
    }

    private CardDto mapToDto(Card card){
        return CardDto.builder()
                .id(card.getId())
                .cardNumber(card.getCardNumber())
                .patientId(card.getPatient().getId())
                .balance(card.getBalance())
                .build();
    }
}
