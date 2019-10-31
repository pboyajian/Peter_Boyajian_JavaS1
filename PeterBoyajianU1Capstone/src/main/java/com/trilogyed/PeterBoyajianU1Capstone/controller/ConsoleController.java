package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console){
        return serviceLayer.addConsole(console);
    }
    @GetMapping
    public List<Console> getAllConsoles(){
        return serviceLayer.getAllConsoles();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateConsole(@RequestBody @Valid Console console){
        serviceLayer.updateConsole(console);
    }
    @GetMapping(value = "/{id}")
    public Console getConsoleById(@PathVariable int id){
        return serviceLayer.getConsole(id);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsoleById(@PathVariable int id){
        serviceLayer.deleteConsoleById(id);
    }
    @GetMapping(value = "/manufacturer/{manufacturer}")
    public List<Console> getAllConsolesByManufacturer(@PathVariable String manufacturer){
        return serviceLayer.getAllConsolesByManufacturer(manufacturer);
    }
}
