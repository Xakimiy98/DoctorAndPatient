package com.example.projectoftest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Card {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cardNumber;
    Double balance;
    @ManyToOne
    Patient patient;
    @ManyToOne
    Doctor doctor;

    public void setId(Long id) {
        this.id = id;
    }

}

