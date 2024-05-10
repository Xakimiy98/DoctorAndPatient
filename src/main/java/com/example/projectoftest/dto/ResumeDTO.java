package com.example.projectoftest.dto;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor()
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResumeDTO {
    @NonNull
    Long id;
    @NonNull
    Integer experienceYear;
    @NonNull
    String gender;
    @NonNull
    String phoneNumber;
    @NonNull
    Integer age;
    @NonNull
    File doctorImage;
    @NonNull
    String profession;
    @NonNull
    Long doctor;


}
