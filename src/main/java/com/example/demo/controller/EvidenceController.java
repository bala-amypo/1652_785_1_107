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
    public EvidenceEntity sendevidence(@RequestBody EvidenceEntity evidence){
        return es.saveuser(evidence);
    }
    @GetMapping("/getev")
    public List<EvidenceEntity> getvalue(){
        return ps.getevidencedata();
    }
    @DeleteMapping("/deleteev/{id}")
    public String deletevalue(@PathVariable Long id){
        return ps.Deleteevidence(id);
    }
    @GetMapping("/foundev/{id}")
    public EvidenceEntity finddata(@PathVariable Long id){
        return ps.evidencedata(id);
    }
    @putMapping("/putev/{id}")
    public EvidenceEntity putdata(@PathVariable Long id,@RequestBody ParcelEntity evidenceentity ){
        return ps.postevidence(id,evidenceentity);
    }
}