package com.chirag.expense_tracker.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/test")
    public ResponseEntity<Object> getTestHello()
    {
        return ResponseEntity.ok().body("hello");
    }
}
