package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tShirt")
public class TShirtController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt){
        return serviceLayer.addTShirt(tShirt);
    }
    @GetMapping
    public List<TShirt> getAllTShirts(){
        return serviceLayer.getAllTShirts();
    }
    @PutMapping
    public void updateTShirt(@RequestBody @Valid TShirt tShirt){
        serviceLayer.updateTShirt(tShirt);
    }
    @GetMapping(value = "/{id}")
    public TShirt getTShirtById(@PathVariable int id){
        return serviceLayer.getTShirt(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteTShirtById(@PathVariable int id){
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
