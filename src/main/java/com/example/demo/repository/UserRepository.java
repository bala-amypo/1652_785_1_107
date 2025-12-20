package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.repository.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}