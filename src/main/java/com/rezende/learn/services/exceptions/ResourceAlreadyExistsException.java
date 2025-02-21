package com.rezende.learn.services.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }

    public ResourceAlreadyExistsException(String msg, Object...args) {
        super(String.format(msg, args));
    }
}
