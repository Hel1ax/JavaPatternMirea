package org.example.service;

import org.example.entity.Bank;
import org.example.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public Bank findById(Long id) {
        return bankRepository.findById(id).orElse(null);
    }

    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    public void deleteById(Long id) {
        bankRepository.deleteById(id);
    }
}