package com.example.demo.repositoty;

public interface ClaimRuleRepository extends JpaRepository<ClaimRule, Long> {
    List<ClaimRule> findAll();
}
