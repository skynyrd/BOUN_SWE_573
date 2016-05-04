package com.toysforshots.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String genericExceptionHandler(){
        return "something is wrong...";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String specificExceptionHandler(){
        return "something illegal happened";
    }
}
