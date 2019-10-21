package com.company.reccolldao.service;

import com.company.reccolldao.dao.AlbumDao;
import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.dao.TrackDao;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    public AlbumViewModel saveAlbum(AlbumViewModel albumViewModel){
        Album album=new Album();
        album.setTitle(albumViewModel.getTitle());
        album.setReleaseDate(albumViewModel.getReleaseDate());
        album.setListPrice(albumViewModel.getListPrice());
        album.setArtistId(albumViewModel.getArtist().getId());
        album.setLabelId(albumViewModel.getLabel().getId());
        album=albumDao.addAlbum(album);
        albumViewModel.setId(album.getId());
        //handle the tracks
        List<Track> tracks=albumViewModel.getTracks();
        tracks.stream().forEach(a->{a.setAlbumId(albumViewModel.getId());
                                        trackDao.addTrack(a);});
        tracks= trackDao.getTracksByAlbum(albumViewModel.getId());
        albumViewModel.setTracks(tracks);
        return albumViewModel;
    }

    public AlbumViewModel findAlbum(int id){
        Album album=albumDao.getAlbum(id);
        return buildViewModel(album);
    }

    public List<AlbumViewModel> findAllAlbums(){
        List<Album> albums=albumDao.getAllAlbums();
        List<AlbumViewModel> albumViewModels=new ArrayList<>();
        for (Album album:albums) {albumViewModels.add(buildViewModel(album));}
        return albumViewModels;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel albumViewModel){
        Album album=new Album();
        album.setTitle(albumViewModel.getTitle());
        album.setReleaseDate(albumViewModel.getReleaseDate());
        album.setListPrice(albumViewModel.getListPrice());
        album.setArtistId(albumViewModel.getArtist().getId());
        album.setLabelId(albumViewModel.getLabel().getId());
        albumDao.updateAlbum(album);
        List<Track> tracks=trackDao.getTracksByAlbum(albumViewModel.getId());
        tracks.stream().forEach(a->trackDao.deleteTrack(a.getId()));

        List<Track> tracksUpdated=trackDao.getTracksByAlbum(albumViewModel.getId());
          tracksUpdated.stream().forEach(a->{
            a.setAlbumId(albumViewModel.getId());
            trackDao.addTrack(a);});
    }

    public AlbumViewModel buildViewModel(Album album) {
        Artist artist=artistDao.getArtist(album.getArtistId());
        Label label=labelDao.getLabel(album.getLabelId());
        List<Track> tracks=trackDao.getTracksByAlbum(album.getId());
        AlbumViewModel returnVal=new AlbumViewModel();
        returnVal.setId(album.getId());
        returnVal.setTitle(album.getTitle());
        returnVal.setListPrice(album.getListPrice());
        returnVal.setArtist(artist);
        returnVal.setLabel(label);
        returnVal.setTracks(tracks);
        return returnVal;
    }

    @Transactional
    public void removeAlbum(int album_id){
        AlbumViewModel albumViewModel=findAlbum(album_id);
        albumViewModel.getTracks().stream().forEach(t->trackDao.deleteTrack(t.getId()));
        albumDao.deleteAlbum(album_id);
    }

    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public ArtistDao getArtistDao() {
        return artistDao;
    }

    public void setArtistDao(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public LabelDao getLabelDao() {
        return labelDao;
    }

    public void setLabelDao(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    public TrackDao getTrackDao() {
        return trackDao;
    }

    public void setTrackDao(TrackDao trackDao) {
        this.trackDao = trackDao;
    }
}
