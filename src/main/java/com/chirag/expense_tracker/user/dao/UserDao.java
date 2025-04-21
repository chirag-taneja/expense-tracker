package com.chirag.expense_tracker.user.dao;

import com.chirag.expense_tracker.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,String> {
}
