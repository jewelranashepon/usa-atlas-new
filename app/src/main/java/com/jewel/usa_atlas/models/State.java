package com.jewel.usa_atlas.models;

public class State {
    private String name;
    private String capital;
    private String population;
    private String area;
    private int flagResource;

    public State(String name, String capital, String population, String area, int flagResource) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flagResource = flagResource;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public int getFlagResource() {
        return flagResource;
    }
}

