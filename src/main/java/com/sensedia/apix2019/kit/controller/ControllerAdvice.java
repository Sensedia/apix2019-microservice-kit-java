package com.sensedia.apix2019.kit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sensedia.apix2019.kit.exception.MessageError;
import com.sensedia.apix2019.kit.exception.PreconditionFailedException;
import com.sensedia.apix2019.kit.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException notFoundException) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(PreconditionFailedException.class)
    public ResponseEntity<MessageError> handlePreconditionException(
            PreconditionFailedException preconditionFailedException) {
        return new ResponseEntity<>(preconditionFailedException.getErrors(), preconditionFailedException.getStatus());
    }

}
