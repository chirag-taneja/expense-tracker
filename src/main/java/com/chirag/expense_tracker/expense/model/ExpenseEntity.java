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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

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

    @Column(name = "CRT_DATE")
    private LocalDateTime crtDate;

    @Column(name = "CRT_USER")
    private String crtUser;

    @Column(name = "LST_UPDATE_DATE")
    private LocalDateTime lstUpdateDate;

    @Column(name = "LST_UPDATE_USER")
    private String lstUpdateUser;
}