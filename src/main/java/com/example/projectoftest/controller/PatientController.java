package com.example.projectoftest.controller;


import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/save")
    public PatientDto save(@RequestBody PatientDto dto) {
        return patientService.savePatient(dto);
    }
        @PutMapping("/update/{id}")
        public Boolean update(@PathVariable Long id, @RequestBody PatientDto dto){
            return patientService.updatePatient(id, dto);
        }
        @GetMapping("/find/{id}")
        public PatientDto find(@PathVariable Long id){
            return patientService.findPatient(id);
        }
        @DeleteMapping("/delete/{id}")
        public Boolean delete(@PathVariable Long id){
            return patientService.deletePatient(id);
        }

}
