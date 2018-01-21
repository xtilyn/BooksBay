package com.xtilyna.booksbay.booksbay.home.ui;



public interface HomeView {

    void navigateToRegister(); // if user is not signed in, go to login page
    void displayHomefeedError(String message);
    void resetHomefeedError();

    void createAPost();

}
