package com.trilogyed.PeterBoyajianU1Capstone.controller;


import com.trilogyed.PeterBoyajianU1Capstone.exceptions.NotFoundException;
import com.trilogyed.PeterBoyajianU1Capstone.exceptions.InvalidQuantityException;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        BindingResult result=e.getBindingResult();
        List<FieldError> fieldErrors=result.getFieldErrors();
        List<VndErrors.VndError> vndErrorList=new ArrayList<>();

        for (FieldError fieldError :
                fieldErrors) {
            VndErrors.VndError vndError=new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }
        VndErrors vndErrors=new VndErrors(vndErrorList);
        return new ResponseEntity<>(vndErrors,HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> handleOutOfRangeException(HttpMessageNotReadableException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors> handleNotFoundException(NotFoundException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = {InvalidQuantityException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors> handleInvalidQuantityException(InvalidQuantityException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }


}

