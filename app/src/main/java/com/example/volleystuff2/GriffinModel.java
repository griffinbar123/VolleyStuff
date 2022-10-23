package com.example.volleystuff2;

import com.google.gson.annotations.SerializedName;

public class GriffinModel {
    // model items
    @SerializedName("name")
    private String name;
    @SerializedName("releaseDate")
    private int year;
    @SerializedName("description")
    private String description;

    // initializer
    public GriffinModel(final String name, final int year, final String console) {
        setName(name);
        setYear(year);
        setDescription(console);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public void setDescription(final String recentConsole) {
        this.description = recentConsole;
    }
}