package com.example.projectoftest.controller;

import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/save")
    public CardDto save(@RequestBody CardDto dto){
        return cardService.saveCard(dto);
    }
}
