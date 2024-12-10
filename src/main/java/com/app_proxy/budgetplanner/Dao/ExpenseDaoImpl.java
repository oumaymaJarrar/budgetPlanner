package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Dto.ExpenseDto;
import com.app_proxy.budgetplanner.Entities.Expense;
import com.app_proxy.budgetplanner.Repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ExpenseDaoImpl implements ExpenseDao{


    private final ExpenseRepository expenseRepository;

    public ExpenseDaoImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public boolean existsById(Long expenseId) {
        return expenseRepository.existsById(expenseId);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        if (existsById(expense.getId())) {
            log.debug(" expense does not exist to updating");
        }else{
            return expenseRepository.save(expense);
        }
        return null;
    }

    @Override
    public void deleteExpense(Long id) {
      expenseRepository.deleteById(id);
    }
    @Override
    public Optional<Expense> findById(Long id) {
        return expenseRepository.findById(id);
    }
//    @Override
//    public BigDecimal Somme(List<Expense> expenses) {
//        return null;
//    }
}
