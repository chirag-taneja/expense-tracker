package com.chirag.expense_tracker.user.service;

import com.chirag.expense_tracker.user.dto.UserDto;
import com.chirag.expense_tracker.user.dao.UserDao;
import com.chirag.expense_tracker.user.model.Role;
import com.chirag.expense_tracker.user.model.UserEntity;
import com.chirag.expense_tracker.user.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    PasswordEncoder passwordEncoder;

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse saveNewUser(UserDto userDto) {
        //check if username exist or not
        if (userDao.findByUsername(userDto.getUserName()).isPresent()) {
            throw new RuntimeException("User already exists");
        }


        //creating user object with userdto
        UUID uuid = UUID.randomUUID();
        UserEntity user = new UserEntity();
        user.setUserId(uuid.toString());
        user.setCrtUser(uuid.toString());
        user.setCrtDate(LocalDateTime.now());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.USER); // enum value (Java naming convention usually keeps enum constants in uppercase)
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUserName());


        UserEntity save = userDao.save(user);


        //creting userRes obj with userdto
        UserResponse response = new UserResponse();

        response.setUserId(save.getUserId());
        response.setUsername(save.getUsername());
        response.setEmail(save.getEmail());
        response.setFullName(save.getFullName());
        response.setRole(save.getRole());
        response.setCrtDate(save.getCrtDate());

        return response;
    }

    @Override
    public UserEntity findByUserName(String userName) {
        if (userDao.findByUsername(userName).isPresent()) {
            return userDao.findByUsername(userName).get();       }
        else {
            throw new RuntimeException("User not exists");
        }
    }
}
