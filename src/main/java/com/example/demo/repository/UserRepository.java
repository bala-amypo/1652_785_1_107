package com.example.demo.repository;
import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    boolean existsByTrackingNumber(String trackingNumber);
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}

public interface DamageClaimRepository extends JpaRepository<DamageClaim, Long> {
    List<DamageClaim> findByParcel_Id(Long parcelId);
}

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
    long countByClaim_Id(Long claimId);
    List<Evidence> findByClaim_Id(Long claimId);
}

public interface ClaimRuleRepository extends JpaRepository<ClaimRule, Long> {}