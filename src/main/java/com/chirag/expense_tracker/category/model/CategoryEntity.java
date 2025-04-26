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


    private LocalDateTime lstUpdateDate;


    private String lstUpdateUser;

    public CategoryEntity() {
    }

    public CategoryEntity(String categoryId, String categoryName, LocalDateTime crtDate, String crtUser, LocalDateTime lstUpdateDate, String lstUpdateUser) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.crtDate = crtDate;
        this.crtUser = crtUser;
        this.lstUpdateDate = lstUpdateDate;
        this.lstUpdateUser = lstUpdateUser;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
