package com.spring.data.exception;

import java.net.URI;
import java.util.List;

public class ApiException extends RuntimeException {
    private final List<Message> messages;
    private final URI path;

    public ApiException(List<Message> messages, URI path) {
        this.messages = messages;
        this.path = path;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public URI getPath() {
        return path;
    }

}
