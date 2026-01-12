package com.expensetracker.backend.repository;

import com.expensetracker.backend.model.Expense;
import com.expensetracker.backend.model.User;
import com.expensetracker.backend.model.enums.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // ✅ THIS IS THE IMPORTANT ONE
    List<Expense> findByUser(User user);

    // (optional – keep if needed later)
    List<Expense> findByCategoryAndUser(ExpenseCategory category, User user);
}
