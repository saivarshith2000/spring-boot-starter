package com.saivarshith.springbootstarter.service;

import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(CreateTodoRequest dto) {
        Todo todo = new Todo();
        todo.setTitle(dto.getTitle());
        todo.setContent(dto.getContent());
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, UpdateTodoRequest dto) {
        Todo todo = todoRepository.findById(id).orElseThrow();
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
