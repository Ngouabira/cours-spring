package com.ecpi.cours_spring.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends  RuntimeException {

    private final int status;

    public EntityNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }
}
