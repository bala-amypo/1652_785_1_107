package com.example.demo.service;



import java.util.List;
import com.example.demo.entity.EvidenceEntity;
import org.springframework.web.bind.annotation.RequestBody;




public interface EvidenceService {
       EvidenceEntity saveevidence(@RequestBody EvidenceEntity evi);
       List<EvidencelEntity>getevidencedata();
       String Deleteevidence( Long id);
       ParcelEntity evidencedata( Long id);
       ParcelEntity postevidence(Long id,EvidenceEntity Evidence);

      
}