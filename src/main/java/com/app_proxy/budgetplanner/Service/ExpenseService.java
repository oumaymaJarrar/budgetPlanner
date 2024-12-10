package com.app_proxy.budgetplanner.Service;

import com.app_proxy.budgetplanner.Dto.ExpenseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {
    List<ExpenseDto> getAllExpenses();
    boolean deleteExpense(Long id);
    void createExpense(ExpenseDto expenseDto);
    void updateExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long id);
    BigDecimal Somme(List<ExpenseDto> expenses);
}
