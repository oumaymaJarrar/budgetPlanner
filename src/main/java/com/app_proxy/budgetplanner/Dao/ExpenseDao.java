package com.app_proxy.budgetplanner.Dao;

import com.app_proxy.budgetplanner.Dto.ExpenseDto;
import com.app_proxy.budgetplanner.Entities.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseDao {
    List<Expense> getAllExpenses();
    boolean existsById(Long id);
    Expense createExpense(Expense expense);
    Expense updateExpense(Expense expense);
    void deleteExpense(Long id);
    Optional<Expense> findById(Long id);
    //BigDecimal Somme(List<Expense> expenses);
}
