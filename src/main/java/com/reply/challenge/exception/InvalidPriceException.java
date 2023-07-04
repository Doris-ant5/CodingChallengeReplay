package com.reply.challenge.exception;

public class InvalidPriceException extends RuntimeException {

    private static final long serialVersionUID = 1549942897041922888L;

    public InvalidPriceException(String message) {
        super(message);
    }

}