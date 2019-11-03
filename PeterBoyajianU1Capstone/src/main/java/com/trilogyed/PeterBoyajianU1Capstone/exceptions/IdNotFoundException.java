package com.trilogyed.PeterBoyajianU1Capstone.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message) {
        super("The id was not found. "+message);
    }
}
