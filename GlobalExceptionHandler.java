package com.bankingsystem.exception;

import com.bankingsystem.dto.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(
        ResourceNotFoundException.class)
public ResponseEntity<ErrorResponse>
handleNotFound(
        ResourceNotFoundException ex) {

    ErrorResponse error =
            new ErrorResponse(
                    ex.getMessage(),
                    HttpStatus.NOT_FOUND.value(),
                    LocalDateTime.now());

    return new ResponseEntity<>(
            error,
            HttpStatus.NOT_FOUND);
}


@ExceptionHandler(
        InsufficientBalanceException.class)
public ResponseEntity<ErrorResponse>
handleBalance(
        InsufficientBalanceException ex) {

    ErrorResponse error =
            new ErrorResponse(
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    LocalDateTime.now());

    return new ResponseEntity<>(
            error,
            HttpStatus.BAD_REQUEST);
}


@ExceptionHandler(
        Exception.class)
public ResponseEntity<ErrorResponse>
handleAll(
        Exception ex) {

    ErrorResponse error =
            new ErrorResponse(
                    ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    LocalDateTime.now());

    return new ResponseEntity<>(
            error,
            HttpStatus.INTERNAL_SERVER_ERROR);
}


}
