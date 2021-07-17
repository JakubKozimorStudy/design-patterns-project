package com.example.designpatternsproject.handler;

import com.example.designpatternsproject.exception.InvalidTransportStrategyTypeException;
import com.example.designpatternsproject.exception.NotTransportTypeTaskException;
import com.example.designpatternsproject.exception.TaskNotFoundException;
import com.example.designpatternsproject.exception.UserNotFoundException;
import com.example.designpatternsproject.handler.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {
            UserNotFoundException.class,
            TaskNotFoundException.class

    })
    public ResponseEntity<ApiError> handleNotFound(RuntimeException exception) {
        final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiError apiError = ApiError.of(httpStatus.getReasonPhrase(), exception.getMessage(), httpStatus.value());
        return new ResponseEntity<>(apiError, httpStatus);
    }

    @ExceptionHandler(value = {
            InvalidTransportStrategyTypeException.class,
            NotTransportTypeTaskException.class
    })
    public ResponseEntity<ApiError> handleBadRequest(RuntimeException exception) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiError apiError = ApiError.of(httpStatus.getReasonPhrase(), exception.getMessage(), httpStatus.value());
        return new ResponseEntity<>(apiError, httpStatus);
    }
}