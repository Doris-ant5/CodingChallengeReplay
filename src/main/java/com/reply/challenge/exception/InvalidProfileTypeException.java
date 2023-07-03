package com.reply.challenge.exception;

public class InvalidProfileTypeException extends RuntimeException {

    private static final long serialVersionUID = 5391448766223350315L;

    public InvalidProfileTypeException(String message) {
        super(message);
    }

}
