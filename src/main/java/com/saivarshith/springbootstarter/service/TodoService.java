package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(CreateTodoRequest dto);
    Todo updateTodo(Long id, UpdateTodoRequest dto);
    void deleteTodo(Long id);
}
