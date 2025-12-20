package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {
    UserEntity register(User user);
    UserEntity findByEmail(String email);
}
