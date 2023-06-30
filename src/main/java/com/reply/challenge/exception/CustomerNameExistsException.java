package com.reply.challenge.exception;

public class CustomerNameExistsException extends RuntimeException {

    private static final long serialVersionUID = -6283485955294393715L;

    public CustomerNameExistsException(String message) {
        super(message);
    }
}

