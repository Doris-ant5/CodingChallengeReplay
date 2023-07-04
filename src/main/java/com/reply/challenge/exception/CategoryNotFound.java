package com.reply.challenge.exception;

public class CategoryNotFound extends RuntimeException {

    private static final long serialVersionUID = 4079175065565284975L;

    public CategoryNotFound(String message) {
        super(message);
    }

}
