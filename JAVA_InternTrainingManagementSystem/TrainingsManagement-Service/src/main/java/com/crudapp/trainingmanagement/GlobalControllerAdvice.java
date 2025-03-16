package com.crudapp.trainingmanagement;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crudapp.trainingmanagement.exceptions.UserNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleException(Exception ex) {
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
}

@ExceptionHandler(NullPointerException.class)
public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Null pointer exception: " + ex.getMessage());
}

@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + ex.getMessage());
}
}


