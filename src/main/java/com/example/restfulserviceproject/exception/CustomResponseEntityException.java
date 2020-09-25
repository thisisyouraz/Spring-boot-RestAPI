package com.example.restfulserviceproject.exception;

import com.example.restfulserviceproject.response.ResponseFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // It handle all the exceptions .
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ExceptionFormat ex_format=new ExceptionFormat(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(ex_format, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
        ResponseFormat res_format=new ResponseFormat(1,ex.getMessage(),request.getDescription(true));

        return new ResponseEntity<>(res_format, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        ExceptionFormat ex_format=new ExceptionFormat(new Date(),ex.getMessage(),ex.getBindingResult().toString());

        return new ResponseEntity<>(ex_format, HttpStatus.BAD_REQUEST);

    }
}
