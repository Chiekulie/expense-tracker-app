package com.javaguides.expense.service.impl;

import com.javaguides.expense.dto.ExpenseDto;
import com.javaguides.expense.entity.Expense;
import com.javaguides.expense.mapper.ExpenseMapper;
import com.javaguides.expense.repository.ExpenseRepository;
import com.javaguides.expense.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    //inject ExpenseRepository using constructor based DI
    private ExpenseRepository expenseRepository;



    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        //Convert ExpenseDto to Expense entity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        // save expense entity to database
      Expense savedExpense = expenseRepository.save(expense);

      // convert saved expense entity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {

        // get expense entity from rhe database using expense id
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()-> new RuntimeException("Expense not found with id:" + expenseId));

        //convert expense entity ExpenseDto
        return ExpenseMapper.mapToExpenseDto(expense);

    }
}
