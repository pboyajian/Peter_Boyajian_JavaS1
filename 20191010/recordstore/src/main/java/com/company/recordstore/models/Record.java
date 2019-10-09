package com.company.recordstore.models;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Record {
    @NotEmpty(message = "You MUST supply a value for artist, or else...")
    private String artist;
    @NotEmpty(message = "You MUST supply a value for album, or else...")
    private String album;
    private int id;
    private static int counter=0;
    @Min(value = 1000, message = "year should be at least 4 digits")
    @Max(value = 10000, message = "year should be at most 4 digits")
    private short year;

    public Record(String artist, String album) {
        this.artist = artist;
        this.album = album;
        counter++;
        id=counter;
    }

    public Record() {
        id=++counter;
    }

    public Record(String artist, String album, int id) {
        this.artist = artist;
        this.album = album;
        this.id = id;
    }

    public Record(@NotEmpty(message = "You MUST supply a value for artist, or else...") String artist, @NotEmpty(message = "You MUST supply a value for album, or else...") String album, int id, @Min(value = 1000, message = "year should be at least 4 digits") @Max(value = 10000, message = "year should be at most 4 digits") short year) {
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.year = year;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Record.counter = counter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Record(@NotEmpty(message = "You MUST supply a value for artist, or else...") String artist,
                  @NotEmpty(message = "You MUST supply a value for album, or else...") String album,
                  @Min(value = 999, message = "year should be at least 4 digits")
                  @Max(value = 10000, message = "year should be at most 4 digits")short year) {
        this.artist = artist;
        this.album = album;
        this.id = id;
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return getId() == record.getId() &&
                Objects.equals(getArtist(), record.getArtist()) &&
                Objects.equals(getAlbum(), record.getAlbum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getAlbum(), getId());
    }
}
