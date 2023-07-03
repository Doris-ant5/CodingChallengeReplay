package com.reply.challenge.controller;

import com.reply.challenge.exception.AddressResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class AddressControllerAdvice {

    @ExceptionHandler(value = AddressResourceNotFoundException.class)
    public ResponseEntity<String> handleAddressResourceNotFoundException(AddressResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

}
