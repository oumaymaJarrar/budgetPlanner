package com.app_proxy.budgetplanner.Service.Impl;

import com.app_proxy.budgetplanner.Dao.ExpenseDao;
import com.app_proxy.budgetplanner.Dto.ExpenseDto;
import com.app_proxy.budgetplanner.Entities.Expense;
import com.app_proxy.budgetplanner.Mapper.CategorieMapperImpl;
import com.app_proxy.budgetplanner.Mapper.ExpenseMapper;
import com.app_proxy.budgetplanner.Service.ExpenseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseDao expenseDao;
    private final ExpenseMapper expenseMapper;
    private final CategorieMapperImpl categorieMapperImpl;

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseDao.getAllExpenses();
        return expenseMapper.mapToListDto(expenses);
    }

    @Override
    public boolean deleteExpense(Long id) {
        if (expenseDao.existsById(id)){
            expenseDao.deleteExpense(id);
            return true;
        }
        return false;
    }

    @Override
    public void createExpense(ExpenseDto ExpenseDto) {
        expenseDao.createExpense(expenseMapper.mapToEntity(ExpenseDto));
    }

    @Override
    public void updateExpense(ExpenseDto expenseDto) {
        expenseDao.updateExpense(expenseMapper.mapToEntity(expenseDto));
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Optional<Expense> expense = expenseDao.findById(id);
        return expenseMapper.entityToMap(expense.get());
    }

    @Override
    public BigDecimal Somme(List<ExpenseDto> expenses) {
        return null;
    }
    /*


      @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userDao.findById(id);
        return userMapper.mapToDto(user.get());
    }
     */
}
