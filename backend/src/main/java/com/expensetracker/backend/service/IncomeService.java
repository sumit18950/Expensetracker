package com.expensetracker.backend.service;

import com.expensetracker.backend.model.Income;
import com.expensetracker.backend.model.User;
import com.expensetracker.backend.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    // ✅ SAVE INCOME
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    // ✅ GET INCOME BY USER
    public List<Income> getIncomeByUser(User user) {
        return incomeRepository.findByUserId(user.getId());
    }

    // ✅ DELETE INCOME
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
