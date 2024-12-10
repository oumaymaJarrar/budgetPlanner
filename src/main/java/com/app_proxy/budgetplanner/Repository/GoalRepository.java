package com.app_proxy.budgetplanner.Repository;

import com.app_proxy.budgetplanner.Entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {
}
