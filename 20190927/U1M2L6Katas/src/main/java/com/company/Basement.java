package com.company;

public class Basement extends Room {
    private String games="_";

    public Basement(int squareFeet, String color, int numDoors, int numWindows, String games) {
        super(squareFeet, color, numDoors, numWindows);
        this.games = games;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public void addGame(String game){
        games+="_"+game;

    }
}
