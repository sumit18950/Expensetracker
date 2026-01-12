package com.expensetracker.backend.controller;

import com.expensetracker.backend.model.Income;
import com.expensetracker.backend.model.User;
import com.expensetracker.backend.repository.UserRepository;
import com.expensetracker.backend.service.IncomeService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IncomeService incomeService;
    private final UserRepository userRepository;

    public IncomeController(IncomeService incomeService, UserRepository userRepository) {
        this.incomeService = incomeService;
        this.userRepository = userRepository;
    }

    // ✅ ADD INCOME (JWT user)
    @PostMapping
    public Income addIncome(
            @RequestBody Income income,
            Authentication authentication
    ) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        income.setUser(user);
        return incomeService.addIncome(income);
    }

    // ✅ GET INCOME (JWT user)
    @GetMapping
    public List<Income> getIncome(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return incomeService.getIncomeByUser(user);
    }

    // ✅ DELETE INCOME
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
