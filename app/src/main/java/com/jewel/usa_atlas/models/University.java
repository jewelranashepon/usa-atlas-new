package com.jewel.usa_atlas.models;

public class University {
    private String name;
    private String location;
    private String description;
    private int imageResource;

    public University(String name, String location, String description, int imageResource) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}

