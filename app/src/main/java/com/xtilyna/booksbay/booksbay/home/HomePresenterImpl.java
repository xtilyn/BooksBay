package com.xtilyna.booksbay.booksbay.home;


import com.xtilyna.booksbay.booksbay.home.events.HomeEvent;
import com.xtilyna.booksbay.booksbay.home.ui.HomeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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

    @Override
    @Subscribe
    public void onEventMainThread(HomeEvent event) {
        switch (event.getEventType()) {
            case HomeEvent.onFailedToRecoverSession:
                failedToRecoverSession();
                break;
        }
    }

    private void failedToRecoverSession() {
        // TODO
    }


}
