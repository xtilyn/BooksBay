package com.xtilyna.booksbay.booksbay.menu;


public interface MenuRepository {

    // for adding/removing firebase authStateListener
    void onStart();
    void onStop();

    void logoutUser();
    void fetchUserAccountSettings();

}
