package com.telran.person.controller;

import com.telran.person.validation.ViolationDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<ViolationDto> handleDtoValidationException(MethodArgumentNotValidException ex){ // validation inside object Dto
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        return errors.stream()
                .map(error -> new ViolationDto(((FieldError) error).getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        // we created a Map, where key = FieldName and value = our Message (variables from ViolationDto)
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ViolationDto> handleArgumentValidationException(ConstraintViolationException ex){
        // validates annotation of method argument (for example @Min)
        return ex.getConstraintViolations().stream()
                .map(cv -> new ViolationDto(cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());
    }

}
