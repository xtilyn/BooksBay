package com.xtilyna.booksbay.booksbay.home;


import com.xtilyna.booksbay.booksbay.home.events.HomeEvent;

public interface HomePresenter {

    // callback methods for registering & unregistering eventbus
    void onStart();
    void onStop();

    void createAPost();
    void onEventMainThread(HomeEvent event);

}
