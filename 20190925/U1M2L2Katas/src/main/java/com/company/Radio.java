package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer,String model,int numSpeakers,String station, int volume, boolean powered){
        this.manufacturer=manufacturer;
        this.model=model;
        this.numSpeakers=numSpeakers;
        this.station=station;
        this.volume=volume;
        this.powered=powered;
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public void setNumSpeakers(int numSpeakers) {
        this.numSpeakers = numSpeakers;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStation() {
        return station;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public boolean isPowered() {
        return powered;
    }

    public void togglePower(){
        powered=!powered;
    }
}

