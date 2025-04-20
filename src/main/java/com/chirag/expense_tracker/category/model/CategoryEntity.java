package com.chirag.expense_tracker.category.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "category", uniqueConstraints = {@UniqueConstraint(name = "uniques", columnNames = {"CATEGORY_NAME"})})
public class CategoryEntity {

    @Id
    private String categoryId;

    @Column(name = "CATEGORY_NAME",nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private LocalDateTime crtDate;

    @Column(nullable = false)
    private String crtUser;

    @Column(nullable = false)
    private LocalDateTime lstUpdateDate;

    @Column(nullable = false)
    private String lstUpdateUser;

}
