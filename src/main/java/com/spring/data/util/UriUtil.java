package com.spring.data.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriUtil {

    public static URI path() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand()
                .toUri();
    }
    public static URI path(Object... uriVariableValues) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand(uriVariableValues)
                .toUri();
    }

}
