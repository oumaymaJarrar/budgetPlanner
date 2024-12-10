package com.app_proxy.budgetplanner.Repository;

import com.app_proxy.budgetplanner.Entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
}
