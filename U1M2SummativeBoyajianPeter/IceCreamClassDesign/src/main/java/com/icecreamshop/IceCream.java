package com.icecreamshop;

public class IceCream {
    private double costPerScoop;
    private double pricePerScoop;
    private String flavorName;
    private boolean hasNuts;
    private double supplyInLiters;
    private double demandInLiters;

    public IceCream(double costPerScoop, double pricePerScoop, String flavorName, boolean hasNuts) {
        this.costPerScoop = costPerScoop;
        this.pricePerScoop = pricePerScoop;
        this.flavorName = flavorName;
        this.hasNuts = hasNuts;
    }
    
    public void resupply(){
        if (supplyInLiters<demandInLiters){
        supplyInLiters=demandInLiters;
        }else{
            System.out.println("Supply already full.");
        }
    }

    public void makeShake(boolean isSmall){
        String size="small";
        if (!isSmall){
            size="large";
        }
        System.out.println("One "+size+" shake, coming up...");
    }

    public double getSupplyInLiters() {
        return supplyInLiters;
    }

    public void setSupplyInLiters(double supplyInLiters) {
        this.supplyInLiters = supplyInLiters;
    }

    public double getDemandInLiters() {
        return demandInLiters;
    }

    public void setDemandInLiters(double demandInLiters) {
        this.demandInLiters = demandInLiters;
    }

    public void makeNScoops(int n){
        System.out.println(n+" scoops, coming up!");
    }

    public double getCostPerScoop() {
        return costPerScoop;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public boolean isHasNuts() {
        return hasNuts;
    }

    public void setHasNuts(boolean hasNuts) {
        this.hasNuts = hasNuts;
    }
}
