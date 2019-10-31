package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {
    private ServiceLayer serviceLayer;
    @PostMapping
    public Console createConsole(@RequestBody @Valid Console console){
        return serviceLayer.addConsole(console);
    }
    @GetMapping
    public List<Console> getAllConsoles(){
        return serviceLayer.getAllConsoles();
    }
    @PutMapping
    public void updateConsole(@RequestBody @Valid Console console){
        serviceLayer.updateConsole(console);
    }
    @GetMapping(value = "/{id}")
    public Console getConsoleById(@PathVariable int id){
        return serviceLayer.getConsole(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteConsoleById(@PathVariable int id){
        serviceLayer.deleteConsoleById(id);
    }
}
