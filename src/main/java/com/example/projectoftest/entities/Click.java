package com.example.projectoftest.entities;

import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Component
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double balance;
    final double komisya = 0.001;
    final double patientKomisya = 0.001;
}
