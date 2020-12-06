package org.autoservice.controller;

import org.autoservice.service.dto.ResponseDto;
import org.autoservice.service.exception.ValidatorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex,
                new ResponseDto("Something went wrong, try again", 500, ((ServletWebRequest) request).getRequest().getRequestURI()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                new ResponseDto("Object wasn't found", 404, ((ServletWebRequest) request).getRequest().getRequestURI()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = ValidatorException.class)
    protected ResponseEntity<Object> handleValidatation(ValidatorException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                new ResponseDto("Validation exception : " + ex.getMessage(), 409, ((ServletWebRequest) request).getRequest().getRequestURI()),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
