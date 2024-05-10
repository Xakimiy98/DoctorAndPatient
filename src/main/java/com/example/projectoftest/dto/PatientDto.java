package com.example.projectoftest.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PatientDto {
    Long id;
    List<Long> cardsId;
    String name;

}
