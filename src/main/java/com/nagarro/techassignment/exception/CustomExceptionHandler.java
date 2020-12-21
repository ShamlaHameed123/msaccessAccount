package com.nagarro.techassignment.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    	Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
       
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }

 
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
    	 Map<String, Object> body = new LinkedHashMap<>();
         body.put("timestamp", LocalDateTime.now());
         body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	Map<String, Object> body = new LinkedHashMap<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            body.put("field_error", error.getDefaultMessage());
        }
       
        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
     
}
