package com.expensetracker.backend.controller;

import com.expensetracker.backend.model.Expense;
import com.expensetracker.backend.model.User;
import com.expensetracker.backend.repository.UserRepository;
import com.expensetracker.backend.service.ExpenseService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:5173") // frontend port
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserRepository userRepository;

    public ExpenseController(ExpenseService expenseService,
                             UserRepository userRepository) {
        this.expenseService = expenseService;
        this.userRepository = userRepository;
    }

    // ✅ ADD EXPENSE
    @PostMapping
    public Expense addExpense(
            @RequestBody Expense expense,
            Authentication authentication
    ) {
        // 🔐 email extracted from JWT
        String email = authentication.getName();
        System.out.println("JWT EMAIL = [" + email + "]");

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found for email: " + email)
                );

        expense.setUser(user);
        return expenseService.saveExpense(expense);
    }

    // ✅ GET EXPENSES (FOR LOGGED-IN USER)
    @GetMapping
    public List<Expense> getExpenses(Authentication authentication) {

        String email = authentication.getName();
        System.out.println("FETCH EXPENSES FOR EMAIL = [" + email + "]");

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found for email: " + email)
                );

        return expenseService.getExpensesByUser(user);
    }
}
