package com.chirag.expense_tracker.category.service;

import com.chirag.expense_tracker.category.model.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    Optional<CategoryEntity> getCategoryById(String id);

    CategoryEntity saveCategory(CategoryEntity categoryEntity, String user);

    void deleteCategory(String id);
}
