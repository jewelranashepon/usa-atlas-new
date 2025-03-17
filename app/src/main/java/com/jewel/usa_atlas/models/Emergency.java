package com.jewel.usa_atlas.models;

public class Emergency {
    private String number;
    private String name;
    private String description;
    private String phoneUri;

    public Emergency(String number, String name, String description, String phoneUri) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.phoneUri = phoneUri;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoneUri() {
        return phoneUri;
    }
}

