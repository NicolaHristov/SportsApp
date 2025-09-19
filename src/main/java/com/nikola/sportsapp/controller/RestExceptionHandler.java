package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.model.dto.ApiErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.Instant;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorDto> handleBadRequest(IllegalArgumentException ex, HttpServletRequest req) {
        ApiErrorDto body = new ApiErrorDto(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiErrorDto> handleIO(IOException ex, HttpServletRequest req) {
        ApiErrorDto body = new ApiErrorDto(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Invalid file",
                ex.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDto> handleGeneric(Exception ex, HttpServletRequest req) {
        ApiErrorDto body = new ApiErrorDto(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage() != null ? ex.getMessage() : "Unexpected error",
                req.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

}
