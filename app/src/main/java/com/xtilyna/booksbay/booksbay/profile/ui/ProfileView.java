package com.xtilyna.booksbay.booksbay.profile.ui;


public interface ProfileView {

    void navigateToLogin(); // if user is not signed in, go to login page
    void displayProfileError(String message);
    void resetProfileError();

    void createAPost();

}
