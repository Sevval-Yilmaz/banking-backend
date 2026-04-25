package com.example.learning.user_demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<ToDo> getTodos() {
        return toDoService.getTodos();
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable Long id) {
        return toDoService.getTodoById(id);
    }

    @PostMapping
    public ToDo addTodo(@RequestBody ToDo todo) {
        return toDoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        toDoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable Long id, @RequestBody ToDo todo ) {
        return toDoService.updateTodo(id, todo);
    }
}
