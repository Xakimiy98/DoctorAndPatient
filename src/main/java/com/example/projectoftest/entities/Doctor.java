package com.example.projectoftest.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String userName;
    String password;
    @OneToMany(mappedBy = "doctor")
    List<Resume> resumes;
    @OneToMany(mappedBy = "doctor")
    List<Card> cards;
}
