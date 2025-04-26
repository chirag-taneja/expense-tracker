package com.chirag.expense_tracker.user.service;

import com.chirag.expense_tracker.user.dto.UserDto;
import com.chirag.expense_tracker.user.model.UserEntity;
import com.chirag.expense_tracker.user.vo.UserResponse;

public interface UserService {
    UserResponse saveNewUser(UserDto userDto);

    UserEntity findByUserName(String userName);
}
