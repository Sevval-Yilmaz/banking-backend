package com.example.learning.user_demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private List<ToDo> todos = new ArrayList<>();
    private Long idCounter = 0L;

    public List<ToDo> getTodos() {
        return todos;
    }

    public ToDo getTodoById(Long id) {
        for (ToDo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public ToDo addTodo(ToDo todo) {
        todo.setId(idCounter);
        idCounter++;
        todos.add(todo);
        System.out.println("Todo hinzugefügt");
        return todo;
    }

    public void deleteTodo(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    public ToDo updateTodo(Long id, ToDo todo ) {
        for (ToDo t : todos) {
            if (t.getId().equals(id)) {
                t.setTask(todo.getTask());
                t.setDone(todo.isDone());
                return t;
            }
        }
        return null;
    }
}
