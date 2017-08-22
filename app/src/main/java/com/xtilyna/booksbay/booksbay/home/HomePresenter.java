package com.xtilyna.booksbay.booksbay.home;


public interface HomePresenter {

    // callback methods for registering & unregistering eventbus
    void onStart();
    void onStop();

    void createAPost();

}
