package com.icecreamfactory;

public class IceCream {
    //Each Instance of IceCream is a single flavor.
    private double costPerLiter;
    private double pricePerLiter;
    private String flavorName;
    private String [] ingredients;
    private double supplyLiters;//Liters of Ice Cream currently in supply.
    private double demandLiters;//Target number of Liters to have in Supply.
    private double totalCost;//total cost of ice cream in stock
    private double grossIncome;

    public IceCream(double costPerLiter, double pricePerLiter, String flavorName, String[] ingredients, double demandLiters) {
        this.costPerLiter = costPerLiter;
        this.pricePerLiter = pricePerLiter;
        this.flavorName = flavorName;
        this.ingredients = ingredients;
        this.demandLiters = demandLiters;
        this.supplyLiters=0;//start off with no Ice Cream
        this.totalCost=0;//Money spent so far
        this.grossIncome=0;
    }

    public void satisfyDemand(){
        if (supplyLiters>=demandLiters){
            System.out.println("Demand is already satisfied.");
        }else{
            totalCost+=(demandLiters-supplyLiters)*costPerLiter;
            System.out.println("Demand satisfied. "+(demandLiters-supplyLiters)+" L produced.");
            demandLiters=supplyLiters;
        }
    }

    public void sellNLiters(double n){
        if (n>supplyLiters){
            System.out.println("Insufficient supply.");
        }else{
        grossIncome+=n*pricePerLiter;
        supplyLiters-=n;}
    }

    public void makeNLiters(double n){
        supplyLiters+=n;
        totalCost+=n*costPerLiter;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getCostPerLiter() {
        return costPerLiter;
    }

    public void setCostPerLiter(double costPerLiter) {
        this.costPerLiter = costPerLiter;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(double pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public double getSupplyLiters() {
        return supplyLiters;
    }

    public double getDemandLiters() {
        return demandLiters;
    }

    public void setDemandLiters(double demandLiters) {
        this.demandLiters = demandLiters;
    }
}
