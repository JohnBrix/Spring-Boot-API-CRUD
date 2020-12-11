package com.spring.data.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

public class ApiErrorResponse {
    private final int statusCode;
    private final String reasonPhrase;
    private final URI path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;
    @JsonProperty("errors")
    private final List<Message> messages;

    public ApiErrorResponse(HttpStatus httpStatus, LocalDateTime createdAt, List<Message> messages, URI path) {
        this.statusCode = httpStatus.value();
        this.reasonPhrase = httpStatus.getReasonPhrase();
        this.createdAt = createdAt;
        this.messages = messages;
        this.path = path;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public URI getPath() {
        return path;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
