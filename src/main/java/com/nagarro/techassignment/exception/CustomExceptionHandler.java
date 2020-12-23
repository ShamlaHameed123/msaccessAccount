package com.nagarro.techassignment.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nagarro.techassignment.response.ErrorModel;
import com.nagarro.techassignment.response.ExceptionResponse;

 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
    	 ExceptionResponse response=new ExceptionResponse();
         response.setErrorCode("BAD_REQUEST");
         response.setErrorMessage("Will fix the bug soon");
         response.setTimestamp(LocalDateTime.now());

         return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

 
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
    	 ExceptionResponse response=new ExceptionResponse();
         response.setErrorCode("The resource is not found");
         response.setErrorMessage(ex.getMessage());
         response.setTimestamp(LocalDateTime.now());

         return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
 
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

    	 List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
    	            .map(err -> new ErrorModel(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
    	            .distinct()
    	            .collect(Collectors.toList());
    
         return new ExceptionResponse(errorMessages);
    }
     
}
