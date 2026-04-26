package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.TodoResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private List<TodoResponseDto> todos = new ArrayList<>();
    private Long idCounter = 0L;

    public List<TodoResponseDto> getTodos() {
        return todos;
    }

    public TodoResponseDto getTodoById(Long id) {
        for (TodoResponseDto todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public TodoResponseDto addTodo(TodoResponseDto todo) {
        todo.setId(idCounter);
        idCounter++;
        todos.add(todo);
        System.out.println("Todo hinzugefügt");
        return todo;
    }

    public void deleteTodo(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    public TodoResponseDto updateTodo(Long id, TodoResponseDto todo ) {
        for (TodoResponseDto t : todos) {
            if (t.getId().equals(id)) {
                t.setTask(todo.getTask());
                t.setDone(todo.isDone());
                return t;
            }
        }
        return null;
    }
}
