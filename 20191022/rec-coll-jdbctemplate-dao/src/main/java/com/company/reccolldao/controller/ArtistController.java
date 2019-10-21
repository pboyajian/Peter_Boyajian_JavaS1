package com.company.reccolldao.controller;

import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArtistController {
    private ArtistDao artistDao;

    @RequestMapping(value="/artist",method = RequestMethod.GET)
    public List<Artist> getAllArtists(){
        List<Artist> artistList=artistDao.getAllArtists();
        return artistList;
    }

    @PostMapping(value="/artist")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createNewArtist(@RequestBody Artist artist){
        return artistDao.addArtist(artist);
    }

    @RequestMapping(value="/artist/{id}",method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public Artist getArtistById(@PathVariable int id){
        return artistDao.getArtist(id);}


    @RequestMapping(value="/artist/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtistById(@PathVariable int id){
        artistDao.deleteArtist(id);
    }

    @PutMapping(value = "/artist/{id}")
    public void updateArtist(Artist artist){
        artistDao.updateArtist(artist);
    }
}
