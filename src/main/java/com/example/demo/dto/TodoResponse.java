package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.Todo;

public class TodoResponse {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoResponse() {}

    public TodoResponse(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.completed = todo.getCompleted();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }

    public TodoResponse(Long id2, String title2, String description2, boolean completed2) {
        //TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }
}
