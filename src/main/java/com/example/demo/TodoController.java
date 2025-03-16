package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private List<Todo> todos = new ArrayList<>();

    public TodoController() {
        todos.add(new Todo(1L, "공부하기", "스프링부트 공부하기", false));
        todos.add(new Todo(2L, "운동하기", "헬스장 가기", true));
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todos;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo newTodo){
        todos.add(newTodo);
        return newTodo;
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo){
        for(Todo todo : todos){
            if(todo.getId().equals(id)){
                todo.setTitle(updatedTodo.getTitle());
                todo.setDescription(updatedTodo.getDescription());
                todo.setCompleted(updatedTodo.getCompleted());
                return todo;
            }
        }

        return null;
    }
}