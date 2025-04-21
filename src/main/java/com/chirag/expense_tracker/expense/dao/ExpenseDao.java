package com.chirag.expense_tracker.expense.dao;

import com.chirag.expense_tracker.expense.model.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<ExpenseEntity,String> {
}
