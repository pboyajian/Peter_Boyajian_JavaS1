package com.trilogyed.weatherservice.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class Temperature {
    private double tempInKelvin;

//    @Min(value = 10000, message = "zipcode should be at least 5 digits")
//    @Max(value = 99999, message = "zipcode should be at most 5 digits")
    private int zipcode;
    private double fahrenheit;
    private double celsius;

    public Temperature() {
    }

//    public Temperature(double tempInKelvin, @Min(value = 10000, message = "zipcode should be at least 5 digits") @Max(value = 99999, message = "zipcode should be at most 5 digits") int zipcode) {
//        this.tempInKelvin = tempInKelvin;
//        this.zipcode = zipcode;
//    }


    public Temperature(double tempInKelvin, int zipcode) {
        this.tempInKelvin = tempInKelvin;
        this.zipcode = zipcode;
    }

    public double getTempInKelvin() {
        return tempInKelvin;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Temperature(int zipcode) {
        this.tempInKelvin = zipcode/300.0-33;
        this.zipcode=zipcode;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double toF(){
        fahrenheit= (9.0*tempInKelvin/5.0)-459.67;
        return fahrenheit;
    }

    public double toC(){
        celsius= tempInKelvin+273.15;
        return celsius;
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
                ", fahrenheit=" + fahrenheit +
                ", celsius=" + celsius +
                '}';
    }
}
