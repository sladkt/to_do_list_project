package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequest {

    @NotBlank(message = "제목은 필수 항목입니다.")
    @Size(min = 1, max = 20, message = "제목은 1자 이상 20자 이하")
    private String title;

    @Size(max = 100, message = "설명은 최대 100자")
    private String description;
    private boolean completed;

    public TodoRequest() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean getCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
