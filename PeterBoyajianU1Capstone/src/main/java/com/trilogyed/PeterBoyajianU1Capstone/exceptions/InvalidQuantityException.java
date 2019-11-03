package com.trilogyed.PeterBoyajianU1Capstone.exceptions;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String message) {
        super("Invalid quantity entered. "+message);
    }
}
