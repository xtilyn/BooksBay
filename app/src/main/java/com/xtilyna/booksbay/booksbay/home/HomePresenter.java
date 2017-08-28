package com.xtilyna.booksbay.booksbay.home;


import com.xtilyna.booksbay.booksbay.home.events.HomeEvent;

public interface HomePresenter {

    void onStart();
    void onStop();

    void createAPost();
    void onEventMainThread(HomeEvent event);

}
