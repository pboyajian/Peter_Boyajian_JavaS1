package com.company;

public class Bathroom extends Room {
    private int numSinks;

    public Bathroom(int squareFeet, String color, int numDoors, int numWindows, int numSinks) {
        super(squareFeet, color, numDoors, numWindows);
        this.numSinks = numSinks;
    }

    public void flushToilet(){
        System.out.println("*flushed*");
    }
}
