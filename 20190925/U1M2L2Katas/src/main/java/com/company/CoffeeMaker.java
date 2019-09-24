package com.company;

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer,String model,int carafeSize,int cupsLeft,boolean powered){
        this.manufacturer=manufacturer;
        this.model=model;
        this.carafeSize=carafeSize;
        this.cupsLeft=cupsLeft;
        this.powered=powered;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public boolean isPowered() {
        return powered;
    }

    public void brew(){
        cupsLeft=carafeSize;
    }

    public void pourCoffee(int numCups){
        if (numCups<=cupsLeft){
        cupsLeft-=numCups;}
        else{
            System.out.println("There is not enough coffee left");
        }
    }
}
