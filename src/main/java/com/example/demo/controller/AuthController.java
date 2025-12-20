package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class AuthController {
    
    @Autowired UserService service;

    @PostMapping("/post")
    public UserEntity senddata(@RequestBody UserEntity e){
        return service.saveuser(e);
    }
    @GetMapping("/get")
    public List<UserEntity> getvalue(){
        return service.getAlldata();
    }
    @DeleteMapping("/delete/{id}")
    public String deletevalue(@PathVariable Long id){
        return service.Deletedata(id);
    }
    @GetMapping("/find/{id}")
    public UserEntity finddata(@PathVariable Long id){
        return service.getdata(id);
    }
    @putMapping("/put/{id}")
    public UserEntity putdata(@PathVariable Long id,@RequestBody UserEntity entity){
        return service.update(id,entity);
    }
}