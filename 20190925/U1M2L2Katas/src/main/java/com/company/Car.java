package com.company;

public class Car {
    private String make,model,type,color,engine,transmission;
    private double mpg;
    private int numDoors,milesDriven;

    public Car(String make, String model, String type, String color, String engine, String transmission, int numDoors,  double mpg, int milesDriven){
        this.make=make;
        this.model=model;
        this.type=type;
        this.color=color;
        this.engine=engine;
        this.transmission=transmission;
        this.mpg=mpg;
        this.numDoors=numDoors;
        this.milesDriven=milesDriven;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getMake() {
        return make;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public double getMpg() {
        return mpg;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void drive(int miles){
        milesDriven+=miles;
    }
    public void honk(){}
}
