package com.xtilyna.booksbay.booksbay.entities;


import java.util.ArrayList;

public class UserAccountSettings {

    // buying and selling categories for providing users relevant content (required)
    private ArrayList<String> selling_categories;
    private ArrayList<String> buying_categories;

    // user's social media sites to increase credibility (optional)
    private ArrayList<String> websites;


    public UserAccountSettings(ArrayList<String> selling_categories, ArrayList<String> buying_categories, ArrayList<String> websites) {
        this.selling_categories = selling_categories;
        this.buying_categories = buying_categories;
        this.websites = websites;
    }

    public UserAccountSettings(ArrayList<String> selling_categories, ArrayList<String> buying_categories) {
        this.selling_categories = selling_categories;
        this.buying_categories = buying_categories;
    }

    public ArrayList<String> getSelling_categories() {
        return selling_categories;
    }

    public void setSelling_categories(ArrayList<String> selling_categories) {
        this.selling_categories = selling_categories;
    }

    public ArrayList<String> getBuying_categories() {
        return buying_categories;
    }

    public void setBuying_categories(ArrayList<String> buying_categories) {
        this.buying_categories = buying_categories;
    }

    public ArrayList<String> getWebsites() {
        return websites;
    }

    public void setWebsites(ArrayList<String> websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "UserAccountSettings{" +
                "selling_categories=" + selling_categories +
                ", buying_categories=" + buying_categories +
                ", websites=" + websites +
                '}';
    }

}
