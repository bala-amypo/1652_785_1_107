package com.example.demo.service;



import java.util.List;
import com.example.demo.service.UserService;
import com.example.demo.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;




public interface UserService {
       UserEntity saveuser(@RequestBody UserEntity user);
       List<UserEntity>getAlldata();
       String Deletedata(int d);
       UserEntity getdata(int d);
       UserEntity update(int id,StudentEntity entity);

      
}