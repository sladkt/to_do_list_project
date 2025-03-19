package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoRequest;
import com.example.demo.dto.TodoResponse;
import com.example.demo.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev")
@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo API", description = "할 일(Todo) 관리 API")
public class TodoController {

    private final TodoService todoService = new TodoService();

    @GetMapping
    @Operation(summary = "할 일 목록 조회", description = "모든 할 일 목록을 조회합니다.")
    public List<TodoResponse> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    @Operation(summary = "할 일 추가", description = "새로운 할 일을 추가합니다.")
    public TodoResponse addTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.addTodo(todoRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "할 일 수정", description = "해당 ID의 할 일을 수정합니다.")
    public TodoResponse updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return todoService.updateTodo(id, todoRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "할 일 삭제", description = "해당 ID의 할 일을 삭제합니다.")
    public String deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}
