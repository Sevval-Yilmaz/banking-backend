package com.example.learning.user_demo.controller;

import com.example.learning.user_demo.service.ToDoService;
import com.example.learning.user_demo.dto.TodoResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    // Get = Erhalten
    // Post = Hinzufügen
    // Put = Verändern
    // Delete = Löschen

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<TodoResponseDto> getTodos() {
        return toDoService.getTodos();
    }

    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable Long id) {
        return toDoService.getTodoById(id);
    }

    @PostMapping
    public TodoResponseDto addTodo(@RequestBody TodoResponseDto todo) {
        return toDoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoResponseDto todo ) {
        return toDoService.updateTodo(id, todo);
    }
}
