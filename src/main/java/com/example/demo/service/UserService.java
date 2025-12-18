package com.example.demo.service;

import java.util.List;


import com.
import org.springframework.web.bind.annotation.RequestBody;




public interface UserService {
       UserEntity saveuser(@RequestBody UserEntity user);
       List<UserEntity>getAlldata();
       String Deletedata(int d);
       UserEntity getdata(int d);
       UserEntity update(int id,StudentEntity entity);

      
}