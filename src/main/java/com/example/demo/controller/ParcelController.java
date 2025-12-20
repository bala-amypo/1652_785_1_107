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
    
    @Autowired ParcelService ps;

    @PostMapping("/pm")
    public UserEntity sendparcel(@RequestBody UserEntity e){
        return service.saveuser(e);
    }
    @GetMapping("/ge")
    public List<ParcelEntity> getvalue(){
        return service.getparceldata();
    }
    @DeleteMapping("/delete/{id}")
    public String deletevalue(@PathVariable Long id){
        return service.Deleteparceldata(id);
    }
    @GetMapping("/find/{id}")
    public UserEntity finddata(@PathVariable int id){
        return service.getdata(id);
    }
    @putMapping("/put/{id}")
    public UserEntity putdata(@PathVariable int id,@RequestBody UserEntity entity){
        return service.update(id,entity);
    }
}