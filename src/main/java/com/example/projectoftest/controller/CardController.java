package com.example.projectoftest.controller;

import com.example.projectoftest.dto.CardDto;
import com.example.projectoftest.entities.Card;
import com.example.projectoftest.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/save")
    public Card save(@RequestBody CardDto dto){
        return cardService.saveCard(dto);
    }
    @PutMapping("/update/{id}")
    public Boolean update(@PathVariable Long id, @RequestBody CardDto dto){
        return cardService.updateCard(id, dto);
    }
    @GetMapping("/find/{id}")
    public CardDto find(@PathVariable Long id){
        return cardService.findCard(id);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return cardService.deleteCard(id);
    }
}
