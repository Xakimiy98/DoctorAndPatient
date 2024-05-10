package com.example.projectoftest.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorDTO {
    Long id;
    String firstName;
    String lastName;
    String userName;
    String password;
    Integer age;
    String address;
    List<Long> resumes;
    List<Long> cards;
}
