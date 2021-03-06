package com.trilogyed.cityservice.controller;

import com.trilogyed.cityservice.exceptions.InvalidCityNameException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class CityServiceExceptionHandler {

        @ExceptionHandler(value = {InvalidCityNameException.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseEntity<VndErrors> handleInvalidCityNameException(InvalidCityNameException e, WebRequest request) {
            VndErrors error = new VndErrors(request.toString(), e.getMessage());
            ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

