package com.silagedik.todo_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 401: yetkisiz giriş
@ResponseStatus(value=HttpStatus.CREATED)
public class CreatedException extends RuntimeException{

    public CreatedException(String message) {
        super(message);
    }
}
