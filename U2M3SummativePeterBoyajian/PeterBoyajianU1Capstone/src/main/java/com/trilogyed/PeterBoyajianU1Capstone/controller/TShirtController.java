package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.exceptions.NotFoundException;
import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tShirt")
public class TShirtController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt){
        return serviceLayer.addTShirt(tShirt);
    }
    @GetMapping
    public List<TShirt> getAllTShirts(){
        return serviceLayer.getAllTShirts();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTShirt(@RequestBody @Valid TShirt tShirt){
        serviceLayer.updateTShirt(tShirt);
    }
    @GetMapping(value = "/{id}")
    public TShirt getTShirtById(@PathVariable int id){
        TShirt tShirt= serviceLayer.getTShirt(id);
        if (tShirt==null){
            throw new NotFoundException("We did not find a tShirt with an id of "+id);
        }
        return tShirt;
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirtById(@PathVariable int id){
        TShirt tShirt= serviceLayer.getTShirt(id);
        if (tShirt==null){
            throw new NotFoundException("We did not find a tShirt with an id of "+id);
        }
        serviceLayer.deleteTShirtById(id);
    }
    @GetMapping(value = "/size/{size}")
    public List<TShirt> getAllTShirtsBySize(@PathVariable String size){
        return serviceLayer.getAllTShirtsBySize(size);
    }
    @GetMapping(value = "/color/{color}")
    public List<TShirt> getAllTShirtsByColor(@PathVariable String color){
        return serviceLayer.getAllTShirtsByColor(color);
    }
}
