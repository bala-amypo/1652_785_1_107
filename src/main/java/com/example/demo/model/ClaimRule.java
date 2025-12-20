package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimRule {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private String ruleName;

    private String conditionExpression;

    private Double weight;

    @ManyToMany(mappedBy = "appliedRules")
    private Set<DamageClaim> claims;

}