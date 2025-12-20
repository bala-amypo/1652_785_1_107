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
    public parcelEntity sendparcel(@RequestBody ParcelEntity e){
        return ps.saveuser(e);
    }
    @GetMapping("/ge")
    public List<ParcelEntity> getvalue(){
        return ps.getparceldata();
    }
    @DeleteMapping("/del/{id}")
    public String deletevalue(@PathVariable Long id){
        return ps.Deleteparcel(id);
    }
    @GetMapping("/found/{id}")
    public ParcelEntity finddata(@PathVariable Long id){
        return ps.parceldata(id);
    }
    @putMapping("/p/{id}")
    public ParcelEntity putdata(@PathVariable Long id,@RequestBody ParcelEntity entity){
        return ps.post(id,entity);
    }
}