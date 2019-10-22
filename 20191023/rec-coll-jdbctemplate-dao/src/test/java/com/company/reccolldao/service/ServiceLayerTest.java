package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);

    }

    @Test
    public void saveFindAlbum() {
        AlbumViewModel theThingIExpect = new AlbumViewModel();

        theThingIExpect.setListPrice(new BigDecimal("14.99"));
        theThingIExpect.setReleaseDate(LocalDate.of(1999, 05, 15));
        theThingIExpect.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        theThingIExpect.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        theThingIExpect.setLabel(label);

        Track track = new Track();
        track.setRunTime(180);
        track.setAlbumId(1);
        track.setTitle("Number 1 Hit!");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        theThingIExpect.setTracks(tList);

        theThingIExpect = service.saveAlbum(theThingIExpect);

        theThingIExpect.setId(1);
        theThingIExpect.getTracks().get(0).setId(1);


        AlbumViewModel fromService = service.findAlbum(theThingIExpect.getId());

        assertEquals(theThingIExpect, fromService);

    }

    @Test
    public void findAllAlbums() {
        AlbumViewModel theThingIExpect = new AlbumViewModel();

        theThingIExpect.setListPrice(new BigDecimal("14.99"));
        theThingIExpect.setReleaseDate(LocalDate.of(1999, 05, 15));
        theThingIExpect.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist = service.saveArtist(artist);

        theThingIExpect.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        theThingIExpect.setLabel(label);

        Track track = new Track();
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        theThingIExpect.setTracks(tList);
        theThingIExpect.setId(1);
        theThingIExpect.getTracks().get(0).setId(1);
        theThingIExpect.getTracks().get(0).setAlbumId(1);
        List<AlbumViewModel> whatIGot = service.findAllAlbums();
        List<AlbumViewModel> whatIExpect= new ArrayList<>();
        whatIExpect.add(theThingIExpect);
        assertEquals(whatIExpect, whatIGot);

    }

    @Test
    public void saveFindFindAllArtist() {

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);
        Artist fromService = service.findArtist(artist.getId());
        assertEquals(artist, fromService);

        List<Artist> aList = service.findAllArtists();
        assertEquals(1, aList.size());
        assertEquals(artist, aList.get(0));
    }

    @Test
    public void saveFindFindAllLabel() {

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");


        label = service.saveLabel(label);
        Label fromService = service.findLabel(label.getId());
        assertEquals(label, fromService);

        List<Label> lList = service.findAllLabels();
        List<Label> expectedLabels=new ArrayList<>();
        expectedLabels.add(label);
        assertEquals(1, lList.size());
        assertEquals(expectedLabels, lList);
    }

    // Helper methods
    private void setUpArtistDaoMock() {
        artistDao = mock(ArtistDao.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List<Artist> aList = new ArrayList<>();
        aList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(aList).when(artistDao).getAllArtists();
    }

    private void setUpAlbumDaoMock() {
        albumDao = mock(AlbumDao.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setUpLabelDaoMock() {
        labelDao = mock(LabelDao.class);
        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        Label label2 = new Label();
        label2.setName("Blue Note");
        label2.setWebsite("www.bluenote.com");


        List<Label> aList = new ArrayList<>();
        aList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(aList).when(labelDao).getAllLabels();
    }

    private void setUpTrackDaoMock() {
        trackDao=mock(TrackDao.class);
        Track track=new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        Track track2=new Track();
        track2.setAlbumId(1);
        track2.setRunTime(180);
        track2.setTitle("Number 1 Hit!");

        List<Track> tracks=new ArrayList<>();
        tracks.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(tracks).when(trackDao).getAllTracks();
        doReturn(tracks).when(trackDao).getTracksByAlbum(1);
    }

}