package com.example.learning.user_demo.dto;

public class TodoResponseDto {
    private Long id;
    private String task;
    private boolean done;

    public TodoResponseDto(Long id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
