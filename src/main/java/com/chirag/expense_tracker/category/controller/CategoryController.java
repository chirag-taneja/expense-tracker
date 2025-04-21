package com.chirag.expense_tracker.category.controller;

import com.chirag.expense_tracker.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> getTestHello()
    {
        return ResponseEntity.ok().body("hello");
    }
}
