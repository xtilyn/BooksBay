package com.xtilyna.booksbay.booksbay.entities;


import java.util.ArrayList;

public class UserAccountSettings {

    // user's location
    private String location;
    // user's social media sites to increase credibility (optional)
    private ArrayList<String> websites;


    public UserAccountSettings(String location) {
        this.location = location;
    }

    public ArrayList<String> getWebsites() {
        return websites;
    }

    public void setWebsites(ArrayList<String> websites) {
        this.websites = websites;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserAccountSettings{" +
                "location='" + location + '\'' +
                ", websites=" + websites +
                '}';
    }
}
