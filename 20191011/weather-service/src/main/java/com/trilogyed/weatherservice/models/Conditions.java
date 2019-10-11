package com.trilogyed.weatherservice.models;

import java.util.Objects;

public class Conditions {
    private Temperature temp;
    private double windSpeed;
    private String windDirection;
    private String skies;
    private String precipitation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conditions that = (Conditions) o;
        return Double.compare(that.windSpeed, windSpeed) == 0 &&
                Objects.equals(temp, that.temp) &&
                Objects.equals(windDirection, that.windDirection) &&
                Objects.equals(skies, that.skies) &&
                Objects.equals(precipitation, that.precipitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, windSpeed, windDirection, skies, precipitation);
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public Conditions(Temperature temp, double windSpeed, String windDirection, String skies, String precipitation) {
        this.temp = temp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.skies = skies;
        this.precipitation = precipitation;
    }
}
