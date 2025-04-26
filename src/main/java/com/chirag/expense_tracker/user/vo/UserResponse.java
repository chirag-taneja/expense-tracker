package com.chirag.expense_tracker.user.vo;

import com.chirag.expense_tracker.user.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter@Setter
@Builder
@ToString
public class UserResponse {
    private String userId;
    private String username;
    private String email;
    private String fullName;
     private Role role;
    private LocalDateTime crtDate;


    public UserResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(LocalDateTime crtDate) {
        this.crtDate = crtDate;
    }
}
