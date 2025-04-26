package com.chirag.expense_tracker.user.controller;

import com.chirag.expense_tracker.user.dto.LoginDto;
import com.chirag.expense_tracker.user.dto.UserDto;
import com.chirag.expense_tracker.user.model.UserEntity;
import com.chirag.expense_tracker.user.service.UserService;
import com.chirag.expense_tracker.user.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    PasswordEncoder passwordEncoder;

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserDto userDto)
    {
      return ResponseEntity.ok(userService.saveNewUser(userDto));
    }

    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto)
    {
        UserEntity user=userService.findByUserName(loginDto.getUserName());
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword()))
        {
            return ResponseEntity.ok("Login successfully");
        }
        return ResponseEntity.ok("Login Failed");
    }

}
