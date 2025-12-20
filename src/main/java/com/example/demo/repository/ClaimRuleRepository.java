package com.example.demo.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ClaimRuleEntity;

public interface ClaimRuleRepository extends JpaRepository<ClaimRuleEntity, Long> {
    List<ClaimRule> findAll();
}
