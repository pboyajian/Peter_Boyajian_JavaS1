package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.model.Game;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){
        return serviceLayer.addGame(game);
    }
    @GetMapping
    public List<Game> getAllGames(){
        return serviceLayer.getAllGames();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGame(@RequestBody @Valid Game game){
        serviceLayer.updateGame(game);
    }
    @GetMapping(value = "/{id}")
    public Game getGameById(@PathVariable int id){
        return serviceLayer.getGame(id);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable int id){
        serviceLayer.deleteGameById(id);
    }
    @GetMapping(value = "/studio/{studio}")
    public List<Game> getAllGamesByStudio(@PathVariable String studio){
        return serviceLayer.getAllGamesByStudio(studio);
    }
    @GetMapping(value = "/rating/{rating}")
    public List<Game> getAllGamesByRating(@PathVariable String rating){
        return serviceLayer.getAllGamesByRating(rating);
    }
    @GetMapping(value = "/title/{title}")
    public List<Game> getAllGamesByTitle(@PathVariable String title){
        return serviceLayer.getAllGamesByTitle(title);
    }
}
