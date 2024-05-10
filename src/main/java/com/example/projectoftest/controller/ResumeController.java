package com.example.projectoftest.controller;

import com.example.projectoftest.dto.ResumeDTO;
import com.example.projectoftest.entities.Resume;
import com.example.projectoftest.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @PostMapping("/save")
    public Resume save(@RequestBody ResumeDTO dto) {
        return resumeService.saveResumeDTO(dto);
    }

    @PutMapping("/update/{id}")
    public Boolean update(@PathVariable Long id, @RequestBody ResumeDTO dto) {
        return resumeService.updateResume(id, dto);
    }

    @GetMapping("/find/{id}")
    public ResumeDTO find(@PathVariable Long id) {
        return resumeService.findResume(id);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return resumeService.deleteResume(id);
    }
}