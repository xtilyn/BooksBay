package com.xtilyna.booksbay.booksbay.entities;


import java.util.ArrayList;

public class UserAccountSettings {

    // user's location
    // user's social media sites to increase credibility (optional)
    private String websites;

    public UserAccountSettings(String websites) {
        this.websites = websites;
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "UserAccountSettings{"  +
                ", websites=" + websites +
                '}';
    }
}
