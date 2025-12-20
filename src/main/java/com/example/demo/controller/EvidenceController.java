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
public class EvidenceController {
    
    @Autowired EvidenceService es;

    @PostMapping("/postev")
    public EvidenceEntity sendparcel(@RequestBody EvidenceEntity evidence){
        return es.saveuser(evidence);
    }
    @GetMapping("/getev")
    public List<Entity> getvalue(){
        return ps.getparceldata();
    }
    @DeleteMapping("/deleteev/{id}")
    public String deletevalue(@PathVariable Long id){
        return ps.Deleteparcel(id);
    }
    @GetMapping("/foundev/{id}")
    public ParcelEntity finddata(@PathVariable Long id){
        return ps.parceldata(id);
    }
    @putMapping("/putev/{id}")
    public UserEntity putdata(@PathVariable Long id,@RequestBody ParcelEntity entity){
        return ps.post(id,entity);
    }
}