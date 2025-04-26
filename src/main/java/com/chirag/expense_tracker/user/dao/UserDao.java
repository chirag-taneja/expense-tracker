package com.chirag.expense_tracker.user.dao;

import com.chirag.expense_tracker.user.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity,String> {


     Optional<UserEntity> findByUsername(String userName);

}
