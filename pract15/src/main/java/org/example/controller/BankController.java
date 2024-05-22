package org.example.controller;

import org.example.entity.Bank;
import org.example.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.findAll();
    }

    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable Long id) {
        return bankService.findById(id);
    }

    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankService.save(bank);
    }

    @PutMapping("/{id}")
    public Bank updateBank(@PathVariable Long id, @RequestBody Bank bank) {
        bank.setId(id);
        return bankService.save(bank);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) {
        bankService.deleteById(id);
    }
}