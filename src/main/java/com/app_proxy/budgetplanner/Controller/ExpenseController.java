package com.app_proxy.budgetplanner.Controller;

import com.app_proxy.budgetplanner.Dto.ExpenseDto;
import com.app_proxy.budgetplanner.Service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/budgetPlaner/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;
    @GetMapping("")
    public ResponseEntity<List<ExpenseDto>> getExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }
    @PostMapping("")
    public ResponseEntity<Object> addExpense(@RequestBody @Valid ExpenseDto ExpenseDto) {
        expenseService.createExpense(ExpenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !")
        );
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateExpense(
            @PathVariable(name="id") Long id,
            @RequestBody @Valid ExpenseDto ExpenseDto) {
        expenseService.updateExpense(ExpenseDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable(name="id") Long id) {
        boolean deleted = expenseService.deleteExpense(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
