package com.chirag.expense_tracker.authentication.conroller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthController {
    
    @GetMapping("/test")
    public ResponseEntity<Object> getTestHello()
    {
        return ResponseEntity.ok().body("hello");
    }
}
