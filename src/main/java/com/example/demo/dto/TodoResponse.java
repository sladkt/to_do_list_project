package com.example.demo.dto;

public class TodoResponse {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TodoResponse() {}

    public TodoResponse(Long id, String title, String description, boolean completed){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
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
}
