package com.example.demo.service.Impl;

public class UserServiceImpl implements UserService {
    @Autowired UserRepository users;

    @PostMapping("/post")
    public UserEntity postdata()
}