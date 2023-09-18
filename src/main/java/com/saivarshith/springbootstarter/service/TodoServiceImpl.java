package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.model.TodoUser;
import com.saivarshith.springbootstarter.repository.TodoRepository;
import com.saivarshith.springbootstarter.repository.TodoUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoUserRepository userRepository;

    @Override
    public Todo getById(Long id) {
        return todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Todo> getAllTodos(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Todo createTodo(Long userId, CreateTodoRequest dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setCompleted(false);
        TodoUser user = userRepository.findById(userId).orElseThrow();
        todo.setUser(user);
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Long id, UpdateTodoRequest dto) {
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setCompleted(dto.getCompleted());
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
