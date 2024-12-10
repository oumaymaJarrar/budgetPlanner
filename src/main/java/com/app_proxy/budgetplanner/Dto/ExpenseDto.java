package com.app_proxy.budgetplanner.Dto;

import com.app_proxy.budgetplanner.Entities.Balance;
import com.app_proxy.budgetplanner.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ExpenseDto {
    private int id;
    private BigDecimal total_amount;
    private Instant createdAt;
    private Instant updatedAt;
    private List<CategorieDto> categorie;
//    private Balance balance;

}
