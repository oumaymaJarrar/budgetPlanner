package com.app_proxy.budgetplanner.Repository;

import com.app_proxy.budgetplanner.Entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport,Long> {
}
