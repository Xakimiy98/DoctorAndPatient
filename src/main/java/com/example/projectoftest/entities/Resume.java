package com.example.projectoftest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.File;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor()
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer experienceYear;
    String gender;
    String phoneNumber;
    Integer age;
    File doctorImage;
    String profession;
    @ManyToOne
    Doctor doctor;

}
