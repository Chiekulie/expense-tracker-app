package com.javaguides.expense.controller;

import com.javaguides.expense.dto.CategoryDto;
import com.javaguides.expense.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories") //Defines the base URI
public class CategoryController {

    private CategoryService categoryService;

            //Build create category Rest Api
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.createCategory(categoryDto);
      return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //Build Get category by id REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
     CategoryDto category = categoryService.getCategoryById(categoryId);
      return ResponseEntity.ok(category);
    }

    //Build Get All Category Rest API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    //Build update category REST API
    @PutMapping ("{id}")
    public ResponseEntity<CategoryDto>updateCategory(@PathVariable("id") Long categoryId, @RequestBody CategoryDto categoryDto){
    CategoryDto updatedCategory = categoryService.updateCategory(categoryId,categoryDto);
       return ResponseEntity.ok(updatedCategory);
    }

    //Build delete category REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){

        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully.");
    }
}
