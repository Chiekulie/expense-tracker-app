package com.javaguides.expense.service;

import com.javaguides.expense.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId,CategoryDto categoryDto);

    void deleteCategory(Long categoryId);

}
