package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.CreateTodoDTO;
import com.saivarshith.springbootstarter.dto.UpdateTodoDTO;
import com.saivarshith.springbootstarter.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(CreateTodoDTO dto);
    Todo updateTodo(Long id, UpdateTodoDTO dto);
    void deleteTodo(Long id);
}
