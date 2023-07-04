package com.reply.challenge.exception;

public class ProductNameExistsException extends RuntimeException {

    private static final long serialVersionUID = 115838931975229059L;

    public ProductNameExistsException(String message) {
        super(message);
    }

}
