package com.saivarshith.springbootstarter.repository;

import com.saivarshith.springbootstarter.model.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {
    Optional<TodoUser> findByEmail(String email);
}
