package com.company.reccolldao.controller;

import com.company.reccolldao.model.Artist;
import com.company.reccolldao.service.ServiceLayer;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumViewModelController {
    @Autowired
    ServiceLayer serviceLayer;
    @RequestMapping(value = "/album",method = RequestMethod.POST)
    public AlbumViewModel addAlbum(@RequestBody AlbumViewModel albumViewModel){
        return serviceLayer.saveAlbum(albumViewModel);
    }
    @DeleteMapping(value = "/album/{id}")
    public void deleteAlbum(@PathVariable int id){
        serviceLayer.removeAlbum(id);
    }
    @GetMapping(value = "/album/{id}")
    public AlbumViewModel getAlbum(@PathVariable int id){
        return serviceLayer.findAlbum(id);
    }

    @GetMapping(value = "/album")
    public List<AlbumViewModel> getAllAlbums(@PathVariable int id){
       return serviceLayer.findAllAlbums();
    }

    @PutMapping(value = "/album")
    public void updateAlbum(@RequestBody AlbumViewModel albumViewModel){
        serviceLayer.updateAlbum(albumViewModel);
    }
}
