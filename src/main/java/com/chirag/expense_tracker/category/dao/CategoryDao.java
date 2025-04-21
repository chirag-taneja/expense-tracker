package com.chirag.expense_tracker.category.dao;

import com.chirag.expense_tracker.category.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity,String> {
}
