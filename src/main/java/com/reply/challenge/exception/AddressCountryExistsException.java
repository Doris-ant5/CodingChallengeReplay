package com.reply.challenge.exception;

public class AddressCountryExistsException extends RuntimeException {

    private static final long serialVersionUID = -2984857580016398366L;

    public AddressCountryExistsException(String message) {
        super(message);
    }

}
