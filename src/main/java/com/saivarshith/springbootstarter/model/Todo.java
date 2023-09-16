package com.saivarshith.springbootstarter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import javax.xml.transform.Source;
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

    @Column(nullable = false, updatable = false)
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;

    @Column(nullable = false)
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

    private boolean completed = false;
}
