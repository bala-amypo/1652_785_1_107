package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.repository.ParcelEntity;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {
    boolean existsByTrackingNumber(String trackingNumber);
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
