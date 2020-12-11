package com.spring.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND) // 409
public class MeetingDoesNotExistException extends RuntimeException implements Supplier<MeetingDoesNotExistException> {
    Long id;

    public MeetingDoesNotExistException(Long id){


        super("Meeting " + id + " does not exist.");
        this.id = id;
    }

    @Override
    public MeetingDoesNotExistException get() {
        return new MeetingDoesNotExistException(id);
    }
}