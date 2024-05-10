package com.example.projectoftest.controller;

import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService userService;

    @PostMapping("/save")
    public PatientDto save(@RequestBody PatientDto dto){
        return userService.savePatient(dto);
    }
}
