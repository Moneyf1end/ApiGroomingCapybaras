package com.example.capybarasApi.error;

import com.example.capybarasApi.dto.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("Resource not found: {}", e.getMessage());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage()); // Сообщение, которое мы передали в сервисе
        errorResponse.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value())); // "404"

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        log.error("URL Validation error", e);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Invalid parameter in URL: " + e.getMessage());
        errorResponse.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value())); // "400"

        return errorResponse;
    }

    // validation errors - @Valid (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Validation error", e);

        StringBuilder details = new StringBuilder("Validation failed: ");
        e.getBindingResult().getFieldErrors().forEach(error ->
                details.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append("; ")
        );

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(details.toString());
        errorResponse.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value())); // "400"

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // broken JSON (incorrect type, symbol) - 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("Malformed JSON request", e);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Malformed JSON request: Please check the request body syntax and data types.");
        errorResponse.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));

        return errorResponse;
    }

    // 500 all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceptionStatus(Exception e) {
        log.error("Unexpected error", e);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Internal server error");
        errorResponse.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())); // "500"

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
