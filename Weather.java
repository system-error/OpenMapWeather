package com.example.openweathermap;

public class Weather{

    private String main,description;

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){

        return main + ": " + description;
    }
}
