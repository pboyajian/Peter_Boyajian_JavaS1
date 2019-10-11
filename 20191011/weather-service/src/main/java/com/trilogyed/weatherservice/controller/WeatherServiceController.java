package com.trilogyed.weatherservice.controller;

import com.trilogyed.weatherservice.models.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {
    @GetMapping(value = "/temp/{zipcode}")
    public Temperature getTemp(@PathVariable int zipcode){
        return new Temperature(zipcode*1.0);
    }
}
