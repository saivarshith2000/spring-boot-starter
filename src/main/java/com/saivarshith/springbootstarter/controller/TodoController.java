package com.saivarshith.springbootstarter.controller;


import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/all")
    public List<Todo> allTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/new")
    public Todo newTodo(@Valid @RequestBody CreateTodoRequest dto) {
        return todoService.createTodo(dto);
    }

    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @Valid @RequestBody UpdateTodoRequest dto) {
        return todoService.updateTodo(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }
}
