package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev")
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<TodoResponse> getTodos(){
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public TodoResponse addTodo(@RequestBody TodoRequest todoRequest){
        return todoService.addTodo(todoRequest);
    }

    @PutMapping("/todos/{id}")
    public TodoResponse updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest){
       return todoService.updateTodo(id, todoRequest);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }
}