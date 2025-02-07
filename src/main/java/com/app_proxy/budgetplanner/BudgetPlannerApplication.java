package com.app_proxy.budgetplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.app_proxy.budgetplanner"})
public class BudgetPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetPlannerApplication.class, args);
	}
}
