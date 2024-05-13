package com.example.projectoftest.controller;

import com.example.projectoftest.dto.DoctorDTO;
import com.example.projectoftest.entities.Doctor;
import com.example.projectoftest.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/register")
    public Doctor save(@RequestBody DoctorDTO dto){
        return doctorService.saveDoctorDTO(dto);
    }
    @PutMapping("/update/{id}")
    public Boolean update(@PathVariable Long id, @RequestBody DoctorDTO dto){
       return doctorService.updateDoctor(id, dto);
    }
    @GetMapping("/find/{id}")
    public DoctorDTO find(@PathVariable Long id){
        return doctorService.findDoctor(id);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }
}
