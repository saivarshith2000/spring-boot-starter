package com.saivarshith.springbootstarter.repository;

import com.saivarshith.springbootstarter.model.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {
    Optional<TodoUser> findByEmail(String email);
}
