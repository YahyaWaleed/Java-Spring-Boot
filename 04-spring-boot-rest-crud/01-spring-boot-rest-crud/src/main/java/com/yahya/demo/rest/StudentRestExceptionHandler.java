package com.yahya.demo.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // shows that this class is a global exception handler so that you store all exception handlers in one file and not in every controller
public class StudentRestExceptionHandler {

    // this handles the specific student not found exception
    @ExceptionHandler
    public ResponseEntity<ErrorResponseMessage> handleException(StudentNotFoundException exception) {

        // create the error response message
        ErrorResponseMessage error = new ErrorResponseMessage();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return the Response Entity error message
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // this handles all exceptions
    @ExceptionHandler
    public ResponseEntity<ErrorResponseMessage> handleException(Exception exception) {

        // create the error response message
        ErrorResponseMessage error = new ErrorResponseMessage();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return the Response Entity error message
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
