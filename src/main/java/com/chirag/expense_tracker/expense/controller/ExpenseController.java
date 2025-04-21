package com.chirag.expense_tracker.expense.controller;

import com.chirag.expense_tracker.expense.model.ExpenseEntity;
import com.chirag.expense_tracker.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    ExpenseService expenseService;

    @Autowired
    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllExpense()
    {
        return  ResponseEntity.ok().body(expenseService.getAllExpense());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Object> getExpenseById(@PathVariable String id){
        return  ResponseEntity.ok().body(expenseService.getExpenseById(id));
    }

    @PostMapping()
    public ResponseEntity<Object> SaveExpense(@RequestBody ExpenseEntity expenseEntity)
    {
        return new ResponseEntity<>(expenseService.saveExpense(expenseEntity),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseEntity> updateExpense(@PathVariable String id, @RequestBody ExpenseEntity expense) {
        ExpenseEntity updatedExpense = expenseService.updateExpense(id, expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok().build();
    }
}
