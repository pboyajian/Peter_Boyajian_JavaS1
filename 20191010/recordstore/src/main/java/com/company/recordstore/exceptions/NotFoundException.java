package com.company.recordstore.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super("The id was not found. "+message);
    }
}