package com.reply.challenge.exception;

public class EmptyTaxNumberException extends RuntimeException {

    private static final long serialVersionUID = -6691663127194572598L;

    public EmptyTaxNumberException(String message) {
        super(message);
    }

}
