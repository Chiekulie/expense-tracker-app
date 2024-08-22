package com.javaguides.expense.service;

import com.javaguides.expense.dto.ExpenseDto;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long expenseId);
}
