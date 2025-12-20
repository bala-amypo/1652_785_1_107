package com.example.demo.repository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    boolean existsByTrackingNumber(String trackingNumber);
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
