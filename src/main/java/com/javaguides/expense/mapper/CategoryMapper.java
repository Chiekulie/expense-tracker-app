package com.javaguides.expense.mapper;

import com.javaguides.expense.dto.CategoryDto;
import com.javaguides.expense.entity.Category;

public class CategoryMapper {
    //map Category entity
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }
    //map Category entity to Category
    public static CategoryDto mapToCategoryDto(Category category){
        return new  CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
