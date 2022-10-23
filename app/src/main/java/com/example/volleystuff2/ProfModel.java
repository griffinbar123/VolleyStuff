package com.example.volleystuff2;

import com.google.gson.annotations.SerializedName;

public class ProfModel {
    // model items
    @SerializedName("name")
    private String pname;
    @SerializedName("year")
    private int pyear;
    @SerializedName("recentConsole")
    private String pconsole;

    // initializer
    public ProfModel(final String name, final int year, final String console) {
        setName(name);
        setYear(year);
        setConsole(console);
    }

    public String getName() {
        return pname;
    }

    public int getYear() {
        return pyear;
    }

    public String getConsole() {
        return pconsole;
    }

    public void setName(final String name) {
        this.pname = name;
    }

    public void setYear(final int year) {
        this.pyear = year;
    }

    public void setConsole(final String recentConsole) {
        this.pconsole = recentConsole;
    }
}