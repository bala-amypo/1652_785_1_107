package com.example.demo.service;



import java.util.List;
import com.example.demo.entity.EvidenceEntity;
import org.springframework.web.bind.annotation.RequestBody;




public interface EvidenceService {
       EvidenceEntity saveevidence(@RequestBody Entity user);
       List<ParcelEntity>getparceldata();
       String Deleteparcel( Long id);
       ParcelEntity parceldata( Long id);
       ParcelEntity post(int id,ParcelEntity parcel);

      
}