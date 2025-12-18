package com.example.demo.controller;
@RestController
public class AuthController {
    
    @Autowired UserService service;

    @PostMapping("/post")
    public UserEntity senddata(@RequestBody UserEntity e){
        return service.saveuser(e);
    }
    @Get
}