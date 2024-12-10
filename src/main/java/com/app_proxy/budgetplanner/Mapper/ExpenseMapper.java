package com.app_proxy.budgetplanner.Mapper;

import com.app_proxy.budgetplanner.Dto.CategorieDto;
import com.app_proxy.budgetplanner.Dto.ExpenseDto;
import com.app_proxy.budgetplanner.Entities.Categorie;
import com.app_proxy.budgetplanner.Entities.Expense;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring",  uses = {CategorieMapper.class})
public interface ExpenseMapper {
    Expense mapToEntity(ExpenseDto expenseDto);
    ExpenseDto entityToMap(Expense expense);
    List<ExpenseDto> mapToListDto(List<Expense> expenses);

    /*



     */
}
