package com.trilogyed.weatherservice.controller;

import com.trilogyed.weatherservice.models.Conditions;
import com.trilogyed.weatherservice.models.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class WeatherServiceController {
    @GetMapping(value = "/temp/{zipcode}")
    public Temperature getTemp(@PathVariable int zipcode){
        if (zipcode>9999&&zipcode<100000){
        return new Temperature(zipcode);}
        throw new IllegalArgumentException("invalid zip. Must be 5 digits.");
    }

    @GetMapping(value = "/conditions/{zipcode}")
    public Conditions getConditions(@PathVariable int zipcode){
        if (zipcode>9999&&zipcode<100000){
            return new Conditions(zipcode);}
        throw new IllegalArgumentException("invalid zip. Must be 5 digits.");
    }
}
