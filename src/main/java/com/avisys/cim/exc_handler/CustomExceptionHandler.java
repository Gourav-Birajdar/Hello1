package com.avisys.cim.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Annotation to tell sc that this is the class which should be referred for any exception raised in the entire application.
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	//This annotation tell the SC to call the underlying method in case of any exception raised across web application.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
