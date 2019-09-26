package com.company;

public class Kitchen extends Room {
    private String appliances="";

    public String getAppliances() {
        return appliances;
    }

    public void setAppliances(String appliances) {
        this.appliances = appliances;
    }

    public void addAppliance(String appliance){
        appliances+="_"+appliance;
    }
}
