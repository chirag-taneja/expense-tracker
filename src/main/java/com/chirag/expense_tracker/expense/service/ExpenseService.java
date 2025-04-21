package com.chirag.expense_tracker.expense.service;

import com.chirag.expense_tracker.expense.model.ExpenseEntity;

import java.util.List;

public interface ExpenseService {
    List<ExpenseEntity> getAllExpense();

    ExpenseEntity getExpenseById(String id);

    ExpenseEntity saveExpense(ExpenseEntity expenseEntity);

    ExpenseEntity updateExpense(String id, ExpenseEntity expense);

    void deleteExpense(String id);
}
