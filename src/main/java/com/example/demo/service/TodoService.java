package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Todo;
import com.example.demo.TodoRepository;
import com.example.demo.dto.TodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.exception.TodoNotFoundException;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    // 조회
    public List<TodoResponse> getTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponse(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getCompleted()))
                .collect(Collectors.toList());
    }

    // 추가
    public TodoResponse addTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        todo.setCompleted(todoRequest.getCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponse(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getDescription(), savedTodo.getCompleted());
    }

    // 수정
    public TodoResponse updateTodo(Long id, TodoRequest todoRequest){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
        todo.setTitle(todoRequest.getTitle());
        todo.setDescription(todoRequest.getDescription());
        todo.setCompleted(todoRequest.getCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponse(updatedTodo.getId(), updatedTodo.getTitle(), updatedTodo.getDescription(), updatedTodo.getCompleted());
    }

    // 삭제
    public String deleteTodo(Long id){
        if(!todoRepository.existsById(id)){
            throw new TodoNotFoundException(id);
        }

        return "삭제 성공";
    }
}
