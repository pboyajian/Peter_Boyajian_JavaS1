package com.company;

public class Patio {
    private int squareFeet;
    private String equipment="";
    private String floorType;

    public String getEquipment() {
        return equipment;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void addAppliance(String equipment){
        this.equipment+="_"+equipment;
    }
    public void clean(){}
}
