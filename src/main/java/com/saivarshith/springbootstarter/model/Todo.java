package com.saivarshith.springbootstarter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean completed;
}
