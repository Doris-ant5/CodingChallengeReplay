package com.reply.challenge.exception;

public class CustomerResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 120377132153206554L;

    public CustomerResourceNotFoundException(String message) {
        super(message);
    }
}
