package com.javaguides.expense.repository;

import com.javaguides.expense.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    //spring data jap provides implementation for this interface
    //CRUD method to perform CRUD database operation on Category entity
    //spring data jpa provides transaction for all the CRUD method
}
