package com.edwin.task.controller;

import com.edwin.task.domain.dto.ErrorDto;
import com.edwin.task.exception.TaskNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handelValidationExceptions(MethodArgumentNotValidException ex){

        String error_msg = ex.getBindingResult().getFieldErrors()
                .stream().findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed");

        ErrorDto errorDto = new ErrorDto(error_msg);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto> handelTaskNotFoundException (TaskNotFoundException ex){

        UUID taskNotFoundId = ex.getId();
        String errorMessage = String.format("task with ID '%s' not found ", taskNotFoundId);
        ErrorDto errorDto = new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);

    }
}
