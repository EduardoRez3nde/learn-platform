package com.rezende.learn.controllers.handlers;

import com.rezende.learn.dto.exception.CustomErrorDTO;
import com.rezende.learn.services.exceptions.ResourceAlreadyExistsException;
import com.rezende.learn.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest req) {
        Integer status = HttpStatus.NOT_FOUND.value();
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<CustomErrorDTO> resourceAlreadyExistsException(ResourceAlreadyExistsException e, HttpServletRequest req) {
        Integer status = HttpStatus.CONFLICT.value();
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
