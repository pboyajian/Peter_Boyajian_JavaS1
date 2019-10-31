package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.model.Game;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {
    private ServiceLayer serviceLayer;
    @PostMapping
    public Game createGame(@RequestBody @Valid Game game){
        return serviceLayer.addGame(game);
    }
    @GetMapping
    public List<Game> getAllGames(){
        return serviceLayer.getAllGames();
    }
    @PutMapping
    public void updateGame(@RequestBody @Valid Game game){
        serviceLayer.updateGame(game);
    }
    @GetMapping(value = "/{id}")
    public Game getGameById(@PathVariable int id){
        return serviceLayer.getGame(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteGameById(@PathVariable int id){
        serviceLayer.deleteGameById(id);
    }
}
