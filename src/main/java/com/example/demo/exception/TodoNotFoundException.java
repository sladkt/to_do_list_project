package com.example.demo.exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id){
        super("해당 ID의 Todo를 찾을 수 없습니다 : " + id);
    }
}
