package com.example.demo.repository;

import com.example.demo.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    long countByClaim_Id(Long claimId);
    // This MUST have the underscore to match the Test Case Mock
    List<Evidence> findByClaim_Id(Long claimId);
}