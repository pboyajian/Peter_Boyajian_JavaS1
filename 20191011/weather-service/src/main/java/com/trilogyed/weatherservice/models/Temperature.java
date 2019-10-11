package com.trilogyed.weatherservice.models;

import java.util.Objects;

public class Temperature {
    private double tempInKelvin;

    public Temperature(double zipcode) {
        this.tempInKelvin = zipcode/300.0-33;
    }

    public double toF(){
        return (9.0*tempInKelvin/5.0)-459.67;
    }

    public double toC(){
        return tempInKelvin+273.15;
    }

    public void setTempInKelvin(double tempInKelvin) {
        this.tempInKelvin = tempInKelvin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Double.compare(that.tempInKelvin, tempInKelvin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempInKelvin);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "tempInKelvin=" + tempInKelvin +
                '}';
    }
}
