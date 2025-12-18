package com.example.demo.service;
import java.util.List;


public interface UserService {
       UserEntity saveuser(@RequestBody UserEntity user);
       List<UserEntity>getAlldata();
       String Deletedata(int d);
       UserEntity getdata(int d);

      
}