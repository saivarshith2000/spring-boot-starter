package com.saivarshith.springbootstarter.controller;

import com.saivarshith.springbootstarter.dto.CreateTodoRequest;
import com.saivarshith.springbootstarter.dto.UpdateTodoRequest;
import com.saivarshith.springbootstarter.model.Todo;
import com.saivarshith.springbootstarter.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerTests {
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";
    private static RestTemplate restTemplate;
    @Autowired
    private TodoService todoService;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setup() {
        baseUrl = baseUrl + ":" + port + "/todo";
    }

    @Test
    public void testGetAllTodos() {
        todoService.createTodo(new CreateTodoRequest("test-todo", "test-todo-description"));
        List<Todo> todos = restTemplate.getForObject(baseUrl + "/all", List.class);
        assert todos != null;
        assertEquals(1, todos.size());
    }

    @Test
    public void testCreateTodo() {
        CreateTodoRequest request = new CreateTodoRequest("test-todo", "test-todo-description");
        Todo todo = restTemplate.postForObject(baseUrl + "/new", request, Todo.class);
        assert todo != null;
        assertEquals("test-todo",todo.getTitle());
        assertEquals("test-todo-description", todo.getContent());
        assertNotNull(todo.getCreatedAt());
        assertNotNull(todo.getUpdatedAt());
        assertEquals(todo.getCreatedAt(), todo.getUpdatedAt());
        assertFalse(todo.isCompleted());
    }

    @Test
    public void testUpdateTodo() {
        Todo todo = todoService.createTodo(new CreateTodoRequest("test-todo", "test-todo-description"));
        UpdateTodoRequest request = new UpdateTodoRequest("new-title", "new-content", true);
        restTemplate.put(baseUrl + "/update/" + todo.getId(), request);
        Todo updatedTodo = todoService.getById(todo.getId());
        assertEquals(request.getTitle(), updatedTodo.getTitle());
        assertEquals(request.getContent(), updatedTodo.getContent());
        assertEquals(request.getCompleted(), updatedTodo.isCompleted());
        assertNotEquals(updatedTodo.getUpdatedAt(), updatedTodo.getCreatedAt());
    }

    @Test
    public void testDeleteTodo() {
        Todo todo = todoService.createTodo(new CreateTodoRequest("test-todo", "test-todo-description"));
        restTemplate.delete(baseUrl + "/delete/" + todo.getId());
        assertThrows(EntityNotFoundException.class, () -> {
            todoService.getById(todo.getId()) ;
        });
    }
}