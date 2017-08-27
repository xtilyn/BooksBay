package com.xtilyna.booksbay.booksbay.home;


public interface HomeRepository {

    // for adding/removing firebase authStateListener
    void onStart();
    void onStop();

    void loadContent();
    void createAPost();
    void checkLogin();

}
