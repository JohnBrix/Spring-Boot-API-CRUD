package com.spring.data.exception;

import com.spring.data.util.UriUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler{


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiErrorResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(), exception.getMessages(), UriUtil.path());
    }
    //ito naman pag UserNotFound sa login
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        return new ApiErrorResponse(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), exception.getMessages(), UriUtil.path());
    }
    //pag else default ito lalabas
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleUserNotFoundException(Exception exception) {
        List<Message> messages = Arrays.asList(new Message(exception.getMessage()));
        return new ApiErrorResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(), messages, UriUtil.path());
    }

}
