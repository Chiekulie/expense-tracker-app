package com.javaguides.expense.service.impl;

import com.javaguides.expense.dto.CategoryDto;
import com.javaguides.expense.entity.Category;
import com.javaguides.expense.mapper.CategoryMapper;
import com.javaguides.expense.repository.CategoryRepository;
import com.javaguides.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        //convert CategoryDto to category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        //save category object into database - categories
        Category savedCategory = categoryRepository.save(category);
        //Convert savedCategory to CategoryDto
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

      Category category = categoryRepository.findById(categoryId)
              .orElseThrow(()-> new RuntimeException("Category not found with id:" + categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

    List<Category> categories = categoryRepository.findAll();
        return  categories.stream()
            .map(CategoryMapper::mapToCategoryDto)
            .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {

        //get category entity from the database by category
       Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found with id:" + categoryId));

        //update the category entity object and save to database table
        category.setName(categoryDto.name());
         Category updatedCategory = categoryRepository.save(category); // performs update operation
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }


    @Override
    public void deleteCategory(Long categoryId) {

        //Check if a category eith given if exist in a databse
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found with id:" + categoryId));

        categoryRepository.delete(category);
    }
}
