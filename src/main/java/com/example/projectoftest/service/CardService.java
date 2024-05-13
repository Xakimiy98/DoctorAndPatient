package com.example.projectoftest.service;
import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.entities.Patient;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.DoctorRepository;
import com.example.projectoftest.repository.PatientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE, makeFinal = true)
public class CardService {
     CardRepository cardRepository;
     PatientRepository patientRepository;
     DoctorRepository doctorRepository;

    public Card saveCard(CardDto dto){
        Card card = mapToEntity(dto);
        addCard(dto, card);
        return cardRepository.save(card);

    }
    public Boolean deleteCard(Long id) {
       Card card = cardRepository.findById(id).orElse(new Card());
        cardRepository.delete(card);
        return cardRepository.findById(id).isEmpty();
    }
    public CardDto findCard(Long id) {
        return mapToDto(cardRepository.findById(id)
                .orElse(new Card()));
    }
    public Boolean updateCard(Long id, CardDto cardDTO) {
        Card card = cardRepository.findById(id).orElse(new Card());
        cardRepository.delete(card);
        cardRepository.save(mapToEntity(cardDTO));
        return cardRepository.findById(id).isEmpty();
    }

    public Card mapToEntity(CardDto dto){
        return Card.builder()
                .cardNumber(dto.getCardNumber())
                .balance(dto.getBalance())
                .active(dto.getActive())
                .build();
    }

    private CardDto mapToDto(Card card){
        return CardDto.builder()
                .id(card.getId())
                .cardNumber(card.getCardNumber())
                .patientId(card.getPatient().getId())
                .balance(card.getBalance())
                .active(card.getActive())
                .build();
    }

    private void addCard(CardDto dto, Card card){
        if (dto.getPatientId() != null) {
            patientRepository.getReferenceById(dto.getPatientId()).getCards().add(card);
        }else if(dto.getDoctorId() != null) {
            doctorRepository.getReferenceById(dto.getDoctorId()).getCards().add(card);
        }
    }
}
