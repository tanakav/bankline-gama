package com.game.bankline.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<BaseError> objectNotFound(
        ObjectNotFoundException e,
         HttpServletRequest request
         )
    {
    	BaseError error = new BaseError(
            HttpStatus.NOT_FOUND.value(),
            e.getMessage(),
            System.currentTimeMillis());
        
        return ResponseEntity.status(error.getStatus()).body(error);
    }
    
    @ExceptionHandler({DuplicateKeyException.class,RequiredFieldsException.class})
    public ResponseEntity<BaseError> duplicateKey(
    		RuntimeException e,
         HttpServletRequest request
         )
    {
    	BaseError error = new BaseError(
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            System.currentTimeMillis());
        
        return ResponseEntity.status(error.getStatus()).body(error);
    }
    
}
