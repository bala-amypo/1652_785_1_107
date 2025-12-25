package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "damage_claims")
@Data
@NoArgsConstructor
public class DamageClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    private String claimDescription;
    private LocalDateTime filedAt;
    private String status = "PENDING"; // Default for test case 32
    private Double score;

    @ManyToMany
    @JoinTable(name = "claim_rule_mapping")
    private Set<ClaimRule> appliedRules = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        this.filedAt = LocalDateTime.now();
    }
}