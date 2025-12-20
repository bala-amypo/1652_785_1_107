package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageClaimEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String parcel;
    private String claimDescription;
    private String receiverName;
    private Double weightKg;
    private LocalDateTime deliveredAt;

}