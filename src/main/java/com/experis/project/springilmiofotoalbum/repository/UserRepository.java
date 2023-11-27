package com.experis.project.springilmiofotoalbum.repository;

import com.experis.project.springilmiofotoalbum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
