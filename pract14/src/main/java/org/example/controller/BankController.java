package org.example.controller;

import org.example.entity.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banks")
public class BankController {
    private List<Bank> banks = new ArrayList<>();

    @GetMapping
    public List<Bank> getAllBanks() {
        return banks;
    }

    @PostMapping
    public void addBank(@RequestBody Bank bank) {
        banks.add(bank);
    }

    @DeleteMapping("/{name}")
    public void deleteBank(@PathVariable String name) {
        banks.removeIf(bank -> bank.getName().equals(name));
    }

    @PutMapping("/{name}")
    public void updateBank(@PathVariable String name, @RequestBody Bank updatedBank) {
        for (Bank bank : banks) {
            if (bank.getName().equals(name)) {
                bank.setAddress(updatedBank.getAddress());
                break;
            }
        }
    }
}