package com.reply.challenge.exception;

public class ProductResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5941202637209088270L;

    public ProductResourceNotFoundException(String message) {
        super(message);
    }

}
