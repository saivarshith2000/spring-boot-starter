package com.saivarshith.springbootstarter.repository;

import com.saivarshith.springbootstarter.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
