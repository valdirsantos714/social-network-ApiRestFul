package com.valdirsantos714.ApiRestFulRedeSocial.controllers.exceptions;

import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.DataBaseException;
import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.ResourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFound e, HttpServletRequest request) {

        String errorMsg = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError error = new StandartError(Instant.now(), status.value(), errorMsg, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> databaseNotFound(DataBaseException e, HttpServletRequest request) {
        String errorMsg = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError error = new StandartError(Instant.now(), status.value(), errorMsg, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
