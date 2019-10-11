package com.trilogyed.weatherservice.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

public class Temperature {
    private double tempInKelvin;

    @Min(value = 10000, message = "zipcode should be at least 5 digits")
    @Max(value = 99999, message = "zipcode should be at most 5 digits")
    private int zipcode;

    public Temperature() {
    }

    public Temperature(double tempInKelvin, @Min(value = 10000, message = "zipcode should be at least 5 digits") @Max(value = 99999, message = "zipcode should be at most 5 digits") int zipcode) {
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

}
