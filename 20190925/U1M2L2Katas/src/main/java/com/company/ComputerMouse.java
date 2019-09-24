package com.company;

public class ComputerMouse {
    private String manufacturer,model;
    private int xPosition,yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturer, String model,int xPosition,int yPosition, int[] lastClickedLocation){
        this.manufacturer=manufacturer;
        this.model=model;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.lastClickedLocation=lastClickedLocation;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setLastClickedLocation(int[] lastClickedLocation) {
        this.lastClickedLocation = lastClickedLocation;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void move(int deltaX, int deltaY){
        xPosition+=deltaX;
        yPosition+=deltaY;
    }

    public void click(){
        lastClickedLocation[0]=xPosition;
        lastClickedLocation[1]=yPosition;
    };
}
