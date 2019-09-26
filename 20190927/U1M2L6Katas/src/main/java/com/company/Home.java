package com.company;

public class Home {
    private int squareFeet;
    private String color;
    private int numDoors,numWindows,numFloors;
    private Room kitchen,basement,bathroom;
    private Patio patio;

    public Home(int squareFeet, String color, int numDoors, int numWindows, int numFloors, Room kitchen, Room basement, Room bathroom, Patio patio) {
        this.squareFeet = squareFeet;
        this.color = color;
        this.numDoors = numDoors;
        this.numWindows = numWindows;
        this.numFloors = numFloors;
        this.kitchen = kitchen;
        this.basement = basement;
        this.bathroom = bathroom;
        this.patio = patio;
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

    public void setColor(String color) {
        this.color = color;
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

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public Room getKitchen() {
        return kitchen;
    }

    public void setKitchen(Room kitchen) {
        this.kitchen = kitchen;
    }

    public Room getBasement() {
        return basement;
    }

    public void setBasement(Room basement) {
        this.basement = basement;
    }

    public Room getBathroom() {
        return bathroom;
    }

    public void setBathroom(Room bathroom) {
        this.bathroom = bathroom;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }
}
