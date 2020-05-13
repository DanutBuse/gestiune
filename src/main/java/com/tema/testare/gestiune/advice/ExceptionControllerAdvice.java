package com.tema.testare.gestiune.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(value = {EntityNotFoundException.class})
  protected ResponseEntity<Object> handleEntityNotFound(WebRequest request) {
    String bodyOfResponse = "Entity not found for id:" + request.getDescription(false);
    return new ResponseEntity(bodyOfResponse, HttpStatus.NO_CONTENT);
  }
}
