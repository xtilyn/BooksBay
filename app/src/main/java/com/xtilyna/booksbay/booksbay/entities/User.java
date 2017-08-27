package com.xtilyna.booksbay.booksbay.entities;



public class User {

    private String email;
    private String profile_photo;
    private String display_name;


    public User(String email, String profile_photo, String display_name) {
        this.email = email;
        this.profile_photo = profile_photo;
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }
}
