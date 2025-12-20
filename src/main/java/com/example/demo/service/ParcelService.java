package com.example.demo.service;



import java.util.List;
import com.example.demo.service.UserService;
import com.example.demo.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;




public interface ParcelService {
       ParcelEntity saveparcel(@RequestBody UserEntity user);
       List<ParcelEntity>getparceldata();
       String Deleteparcel( Long id);
       ParcelEntity parceldata( Long id);
       ParcelEntity post(int id,ParcelEntity parcel);

      
}