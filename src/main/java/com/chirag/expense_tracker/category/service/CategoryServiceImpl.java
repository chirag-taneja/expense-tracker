package com.chirag.expense_tracker.category.service;

import com.chirag.expense_tracker.category.dao.CategoryDao;
import com.chirag.expense_tracker.category.model.CategoryEntity;
import com.chirag.expense_tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(String id) {
        return categoryDao.findById(id);
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity, String user) {
        categoryEntity.setCrtDate(LocalDateTime.now());
        categoryEntity.setCrtUser(user);
        UUID uuid = UUID.randomUUID();
        categoryEntity.setCategoryId(uuid.toString());
        // If updating, update the last updated details
        if (categoryEntity.getLstUpdateDate() != null) {
            categoryEntity.setLstUpdateDate(LocalDateTime.now());
            categoryEntity.setLstUpdateUser(user);
        }

        return categoryDao.save(categoryEntity);
    }

    @Override
    public void deleteCategory(String id) {
        categoryDao.deleteById(id);
    }
}
