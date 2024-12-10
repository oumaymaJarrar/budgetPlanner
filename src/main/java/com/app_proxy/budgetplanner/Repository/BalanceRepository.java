package com.app_proxy.budgetplanner.Repository;

import com.app_proxy.budgetplanner.Entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {
}
