package com.example.projectoftest.controller;

import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.dto.DoctorDTO;
import com.example.projectoftest.dto.PatientDto;
import com.example.projectoftest.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransactionService transactionService;


    @GetMapping("/t/{gettingBalance}")
    public Boolean transfer(@RequestBody PatientDto patientDto,
                            @RequestBody DoctorDTO doctorDTO,
                            @PathVariable Double gettingBalance){
       return transactionService.tran(patientDto,doctorDTO,gettingBalance);

    }
}
