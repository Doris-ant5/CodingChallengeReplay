package com.reply.challenge.controller;

import com.reply.challenge.exception.CategoryNotFound;
import com.reply.challenge.exception.InvalidPriceException;
import com.reply.challenge.exception.ProductNameExistsException;
import com.reply.challenge.exception.ProductResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(value = ProductResourceNotFoundException.class)
    public ResponseEntity<String> handleProductResourceNotFoundException(ProductResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = ProductNameExistsException.class)
    public ResponseEntity<String> handleProductNameExistsException(ProductNameExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = CategoryNotFound.class)
    public ResponseEntity<String> handleCategoryNotFound(CategoryNotFound ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(value = InvalidPriceException.class)
    public ResponseEntity<String> handleInvalidPriceException(InvalidPriceException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
