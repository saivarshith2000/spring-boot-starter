package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.model.TodoUser;

import java.util.List;

public interface TodoService {
    Todo getById(Long id);
    List<Todo> getAllTodos(Long userId);
    Todo createTodo(Long userId, CreateTodoRequest dto);
    Todo updateTodo(Long id, UpdateTodoRequest dto);
    void deleteTodo(Long id);
}
