package com.saivarshith.springbootstarter.controller;


import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.model.TodoUser;
import com.saivarshith.springbootstarter.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@Tag(name = "Todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/all")
    public List<Todo> allTodos(@AuthenticationPrincipal TodoUser user) {
        return todoService.getAllTodos(user.getId());
    }

    @PostMapping("/new")
    public ResponseEntity<Todo> newTodo(@AuthenticationPrincipal TodoUser user, @Valid @RequestBody CreateTodoRequest dto) {
        return new ResponseEntity<>(todoService.createTodo(user.getId(), dto), HttpStatus.CREATED);
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
