package com.javaguides.expense.repository;

import com.javaguides.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //Spring data jpa provides implementation for this interface
    //CRUD methods to perform CRUD database operation on Expense entity
    //Spring Data JPA provides transaction for all the  CRUD method

}
