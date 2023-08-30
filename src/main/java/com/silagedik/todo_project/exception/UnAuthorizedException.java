package com.silagedik.todo_project.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 401: yetkisiz giriş
@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String message) {
        super(message);
    }
}
