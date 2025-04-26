package com.chirag.expense_tracker.category.controller;

import com.chirag.expense_tracker.category.model.CategoryEntity;
import com.chirag.expense_tracker.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    CategoryService categoryService;


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryEntity>> getCategoryById(@PathVariable String id) {
        return ResponseEntity.ok( categoryService.getCategoryById(id));
    }

    // Create a new category
    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity categoryEntity, @RequestHeader("User") String user) {
        return ResponseEntity.ok(categoryService.saveCategory(categoryEntity, user));
    }

    // Delete category by ID
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }
}
