package com.FadiMagdi.alternative.task.app.controllers;

import com.FadiMagdi.alternative.task.app.domain.dto.ErrorResponseClass;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
public ResponseEntity<ErrorResponseClass> handleIllegalExceptions(RuntimeException ex,
            WebRequest request) {

ErrorResponseClass errorResponse = new ErrorResponseClass(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
                );
return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}

}
