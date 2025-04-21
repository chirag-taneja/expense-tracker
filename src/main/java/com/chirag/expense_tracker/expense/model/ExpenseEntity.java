package com.chirag.expense_tracker.expense.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "expense")
public class ExpenseEntity {

    @Id
    private String expenseId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "EXPENSE_DATE", nullable = false)
    private LocalDateTime expenseDate;

    @Column(name = "USER_ID", nullable = false)
    private Long userId; // Foreign key to UserEntity (manual, flat)

    @Column(name = "CATEGORY_ID", nullable = false)
    private String categoryId; // Foreign key to CategoryEntity (manual, flat)

    @Column(name = "CRT_DATE",nullable = false)
    private LocalDateTime crtDate;

    @Column(name = "CRT_USER",nullable = false)
    private String crtUser;

    @Column(name = "LST_UPDATE_DATE")
    private LocalDateTime lstUpdateDate;

    @Column(name = "LST_UPDATE_USER")
    private String lstUpdateUser;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(LocalDateTime crtDate) {
        this.crtDate = crtDate;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public LocalDateTime getLstUpdateDate() {
        return lstUpdateDate;
    }

    public void setLstUpdateDate(LocalDateTime lstUpdateDate) {
        this.lstUpdateDate = lstUpdateDate;
    }

    public String getLstUpdateUser() {
        return lstUpdateUser;
    }

    public void setLstUpdateUser(String lstUpdateUser) {
        this.lstUpdateUser = lstUpdateUser;
    }
}