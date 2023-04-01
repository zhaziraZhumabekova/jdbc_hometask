package com.peaksoft;

public class City {
    private int id;
private String name;
private int population;
private int countOfRegion;
private String countryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCountOfRegion() {
        return countOfRegion;
    }

    public void setCountOfRegion(int countOfRegion) {
        this.countOfRegion = countOfRegion;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countOfRegion=" + countOfRegion +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
