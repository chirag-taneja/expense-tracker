package com.chirag.expense_tracker.expense.service;

import com.chirag.expense_tracker.expense.dao.ExpenseDao;
import com.chirag.expense_tracker.expense.model.ExpenseEntity;
import com.chirag.expense_tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    ExpenseDao expenseDao;

    @Autowired
    public void setExpenseDao(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public List<ExpenseEntity> getAllExpense() {
        return expenseDao.findAll();
    }

    @Override
    public ExpenseEntity getExpenseById(String id) {
        return expenseDao.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense Not Found"));
    }

    @Override
    public ExpenseEntity saveExpense(ExpenseEntity expenseEntity) {
        UUID uuid = UUID.randomUUID();
        expenseEntity.setExpenseId(uuid.toString());
        expenseEntity.setCrtDate(LocalDateTime.now());
        expenseEntity.setCrtUser("static");
        return expenseDao.save(expenseEntity);
    }

    @Override
    public ExpenseEntity updateExpense(String id, ExpenseEntity expense) {
        ExpenseEntity expenseEntity = expenseDao.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense Not Found"));

        expenseEntity.setTitle(expense.getTitle());
        expenseEntity.setAmount(expense.getAmount());
        expenseEntity.setDescription(expense.getDescription());
        expenseEntity.setExpenseDate(expense.getExpenseDate());
        expenseEntity.setCategoryId(expense.getCategoryId());
        expenseEntity.setLstUpdateDate(LocalDateTime.now());
        expenseEntity.setLstUpdateUser("static");
        // Set other fields as needed

        return expenseDao.save(expenseEntity);
    }

    @Override
    public void deleteExpense(String id) {
        ExpenseEntity expense = expenseDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseDao.delete(expense);
    }
}
