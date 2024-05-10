package com.example.projectoftest.service;

import com.example.projectoftest.dto.ResumeDTO;
import com.example.projectoftest.entities.Doctor;
import com.example.projectoftest.entities.Resume;
import com.example.projectoftest.repository.DoctorRepository;
import com.example.projectoftest.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {
    final ResumeRepository resumeRepository;
    final DoctorRepository doctorRepository;

    public Resume saveResumeDTO(ResumeDTO resumeDTO){
        Resume resume = mapToEntity(resumeDTO);
        return resumeRepository.save(resume);
    }

    public Boolean updateResume(Long id, ResumeDTO resumeDTO){
        Resume resume = resumeRepository.findById(id).orElse(new Resume());
        resumeRepository.delete(resume);
        resumeRepository.save(mapToEntity(resumeDTO));
        return resumeRepository.findById(id).isEmpty();
    }
    public ResumeDTO findResume(Long id){
        return mapToDto(resumeRepository.findById(id).orElse(new Resume()));
    }

    public Boolean deleteResume(Long id){
        Resume resume = resumeRepository.findById(id)
                .orElse(new Resume());
        resumeRepository.delete(resume);
        return resumeRepository.findById(resume.getId()).isEmpty();
    }
    private Resume mapToEntity (ResumeDTO dto){
        return Resume.builder()
                .id(dto.getId())
                .gender(dto.getGender())
                .phoneNumber(dto.getPhoneNumber())
                .profession(dto.getProfession())
                .experienceYear(dto.getExperienceYear())
                .age(dto.getAge())
                .doctorImage(dto.getDoctorImage())
                .doctor(doctorRepository
                        .findById(dto.getDoctor()).orElse(new Doctor()))
                .build();
                
    }
    private ResumeDTO mapToDto (Resume resume){
        return ResumeDTO.builder()
                .id(resume.getId())
                .gender(resume.getGender())
                .experienceYear(resume.getExperienceYear())
                .phoneNumber(resume.getPhoneNumber())
                .profession(resume.getProfession())
                .age(resume.getAge())
                .doctorImage(resume.getDoctorImage())
                .doctor(resume.getDoctor().getId())
                .build();
    }

}
