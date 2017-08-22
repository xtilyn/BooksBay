package com.xtilyna.booksbay.booksbay.home;


import com.xtilyna.booksbay.booksbay.home.ui.HomeView;

import org.greenrobot.eventbus.EventBus;

public class HomePresenterImpl implements HomePresenter{

    private HomeView homeView;
    private EventBus eventBus;


    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        this.eventBus = EventBus.getDefault();
    }

    @Override
    public void onStart() {
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    public void createAPost() {
        homeView.createAPost();
    }
}
