package com.fusionkoding.bruskibeerservice.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List> validationErrorHandler(MethodArgumentNotValidException ex) {
        List<String> errorList = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorList.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errorList.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errorList);
    }
}
