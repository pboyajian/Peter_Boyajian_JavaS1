package com.trilogyed.cityservice.exceptions;

public class InvalidCityNameException extends RuntimeException {
    public InvalidCityNameException(String message) {
        super(message);
    }
}
