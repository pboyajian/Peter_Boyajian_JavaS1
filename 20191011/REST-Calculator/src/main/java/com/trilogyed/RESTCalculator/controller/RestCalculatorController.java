package com.trilogyed.RESTCalculator.controller;

import com.trilogyed.RESTCalculator.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCalculatorController {

    @PostMapping(value="/add")
    @ResponseStatus(HttpStatus.CREATED)
    public double add(@RequestBody Calculator calculator){

        return calculator.sum();
    }

    @PostMapping(value="/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public double subtract(@RequestBody Calculator calculator){

        return calculator.subtract();
    }

    @PostMapping(value="/mult")
    @ResponseStatus(HttpStatus.CREATED)
    public double mult(@RequestBody Calculator calculator){

        return calculator.mult();
    }

    @PostMapping(value="/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public double divide(@RequestBody Calculator calculator){

        return calculator.divide();
    }
    }

