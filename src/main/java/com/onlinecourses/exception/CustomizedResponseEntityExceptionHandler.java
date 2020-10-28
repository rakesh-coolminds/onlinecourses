package com.onlinecourses.exception;

import com.onlinecourses.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity handleBadRequestExceptions(Exception ex, WebRequest request) {
        ErrorDto response=new ErrorDto();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setError(ex.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}