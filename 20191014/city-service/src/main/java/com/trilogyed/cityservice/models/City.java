package com.trilogyed.cityservice.models;

import java.util.Objects;

public class City {
    private String name;
    private String state;
    private int population;
    private boolean isStateCapital;

    public City() {
    }

    public City(String name, String state, int population, boolean isStateCapital) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isStateCapital = isStateCapital;
    }

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
        this.isStateCapital=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isStateCapital() {
        return isStateCapital;
    }

    public void setStateCapital(boolean stateCapital) {
        isStateCapital = stateCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population &&
                isStateCapital == city.isStateCapital &&
                Objects.equals(name, city.name) &&
                Objects.equals(state, city.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state, population, isStateCapital);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", population=" + population +
                ", isStateCapital=" + isStateCapital +
                '}';
    }


}
