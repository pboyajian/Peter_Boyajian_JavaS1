package com.company;

public class Room {
    protected int squareFeet;
    protected String color;
    protected int numDoors,numWindows;

    public Room(){}

    public Room(int squareFeet, String color, int numDoors, int numWindows) {
        this.squareFeet = squareFeet;
        this.color = color;
        this.numDoors = numDoors;
        this.numWindows = numWindows;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getColor() {
        return color;
    }


    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public void addWindow(){
        numWindows++;
    }
    public void addDoor(){
        numDoors++;
    }
    public void clean(){}
    public void paintRoom(String color){
        this.color=color;
    }
}
