package com.example.restservice.controller.httpexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectAlreadyExistsException extends RuntimeException {
    public ObjectAlreadyExistsException() {
        super("Object already exists");
    }
}