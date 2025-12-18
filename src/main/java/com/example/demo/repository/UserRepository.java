package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.repository.UserRepository;



public interface UserRepository extends JpaRepository<UserEntity,Integer> {


}