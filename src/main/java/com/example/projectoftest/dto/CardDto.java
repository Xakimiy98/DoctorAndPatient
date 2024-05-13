package com.example.projectoftest.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardDto {
    Long id;
    Double balance;
    String cardNumber;
    Long patientId;
    Boolean active;
    Long doctorId;
}
