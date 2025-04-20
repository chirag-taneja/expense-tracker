package com.chirag.expense_tracker.user.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "unique_email", columnNames = {"EMAIL"}),
@UniqueConstraint(name = "unique_username",columnNames = "USERNAME")})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "CRT_DATE")
    private LocalDateTime crtDate;

    @Column(name = "CRT_USER")
    private String crtUser;

    @Column(name = "LST_UPDATE_DATE")
    private LocalDateTime lstUpdateDate;

    @Column(name = "LST_UPDATE_USER")
    private String lstUpdateUser;
}

enum Role{
    User,Admin
}

