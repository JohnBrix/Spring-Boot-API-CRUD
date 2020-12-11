package com.spring.data.exception;

import com.spring.data.util.UriUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

public class UserNotFoundException extends ApiException {
    //if usernot found nagmamagic si spring boot para mapunta sya sa ApiExceptionHandler
    public UserNotFoundException(HttpStatus notFound, List<Message> messages, URI path) {
        super(messages, path);
    }
}
