package com.example.projectoftest.service;

import com.example.projectoftest.dto.DoctorDTO;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.entities.Doctor;
import com.example.projectoftest.entities.Resume;
import com.example.projectoftest.repository.CardRepository;
import com.example.projectoftest.repository.DoctorRepository;
import com.example.projectoftest.repository.ResumeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorService {
    DoctorRepository doctorRepository;
    ResumeRepository resumeRepository;
    CardRepository cardRepository;

    public Doctor saveDoctorDTO(DoctorDTO doctorDTO) {
        Doctor doctor = mapToEntity(doctorDTO);
        return doctorRepository.save(doctor);
    }

    public Boolean updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).orElse(new Doctor());
        doctorRepository.delete(doctor);
        doctorRepository.save(mapToEntity(doctorDTO));
        return doctorRepository.findById(id).isEmpty();
    }

    public Boolean deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(new Doctor());
        doctorRepository.delete(doctor);
        return doctorRepository.findById(id).isEmpty();
    }

    public DoctorDTO findDoctor(Long id) {
        return mapToDto(doctorRepository.findById(id)
                .orElse(new Doctor()));
    }

    private Doctor mapToEntity(DoctorDTO doctorDTO) {
        return Doctor.builder()
                .id(doctorDTO.getId())
                .firstName(doctorDTO.getFirstName())
                .lastName(doctorDTO.getLastName())
                .userName(doctorDTO.getUserName())
                .password(doctorDTO.getPassword())
                .cards(cardRepository
                        .findAllById(doctorDTO.getCards()))
                .resumes(resumeRepository
                        .findAllById(doctorDTO.getResumes()))
                .build();
    }

    private DoctorDTO mapToDto(Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .password(doctor.getPassword())
                .userName(doctor.getUserName())
                .cards(doctor.getCards()
                        .stream().map(Card::getId)
                        .collect(toList()))
                .resumes(doctor.getResumes()
                        .stream().map(Resume::getId)
                        .collect(toList()))

                .build();
    }

}
