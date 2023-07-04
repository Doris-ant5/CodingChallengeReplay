package com.reply.challenge.controller;

import com.reply.challenge.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(value = CustomerResourceNotFoundException.class)
    public ResponseEntity<String> handleCustomerResourceNotFoundException(CustomerResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = CustomerNameExistsException.class)
    public ResponseEntity<String> handleCustomerNameExistsException(CustomerNameExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = EmptyTaxNumberException.class)
    public ResponseEntity<String> handleEmptyTaxNumberException(EmptyTaxNumberException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

}
