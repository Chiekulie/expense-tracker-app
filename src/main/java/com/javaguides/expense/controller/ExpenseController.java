package com.javaguides.expense.controller;

import com.javaguides.expense.dto.ExpenseDto;
import com.javaguides.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses") //base URI
public class ExpenseController {

    //inject the ExpenseService using constructor based DI
    private ExpenseService expenseService;

    //Build create expense REST API
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

    ExpenseDto savedExpense = expenseService.createExpense(expenseDto);

    return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    //Build get expense by id REST API
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){

        ExpenseDto expense = expenseService.getExpenseById(expenseId);

        return ResponseEntity.ok(expense);
    }
}
