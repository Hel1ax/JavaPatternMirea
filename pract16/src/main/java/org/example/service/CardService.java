package org.example.service;

import org.example.entity.Card;
import org.example.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }
}
