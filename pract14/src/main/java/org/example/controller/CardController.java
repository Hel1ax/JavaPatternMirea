package org.example.controller;

import org.example.entity.Card;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {
    private List<Card> cards = new ArrayList<>();

    @GetMapping
    public List<Card> getAllCards() {
        return cards;
    }

    @PostMapping
    public void addCard(@RequestBody Card card) {
        cards.add(card);
    }

    @DeleteMapping("/{cardNumber}")
    public void deleteCard(@PathVariable String cardNumber) {
        cards.removeIf(card -> card.getCardNumber().equals(cardNumber));
    }

    @PutMapping("/{cardNumber}")
    public void updateCard(@PathVariable String cardNumber, @RequestBody Card updatedCard) {
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                card.setCode(updatedCard.getCode());
                break;
            }
        }
    }
}