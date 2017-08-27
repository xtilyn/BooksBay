package com.xtilyna.booksbay.booksbay.home;


import android.content.Context;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.events.HomeEvent;
import com.xtilyna.booksbay.booksbay.home.ui.HomeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class HomePresenterImpl implements HomePresenter{

    private final static String TAG = "HomePresenterImpl";

    private EventBus eventBus;

    private HomeView homeView;
    private HomeRepository homeRepository;


    public HomePresenterImpl(HomeView homeView, Context context) {
        Log.d(TAG, "Created new HomePresenterImpl");
        this.homeView = homeView;
        this.eventBus = EventBus.getDefault();
        this.homeRepository = new HomeRepositoryImpl(context);
    }

    @Override
    public void onStart() {
        eventBus.register(this);
        homeRepository.onStart();
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        homeRepository.onStop();
    }

    @Override
    public void createAPost() {
        homeRepository.createAPost();
    }

    @Override
    public void checkLogin() {

    }

    @Override
    @Subscribe
    public void onEventMainThread(HomeEvent event) {
        switch (event.getEventType()) {
            case HomeEvent.onFailedToRecoverSession:
                onFailedToRecoverSession(event.getErrorMessage());
                break;
        }
    }

    private void onFailedToRecoverSession(String errorMessage) {
        Log.d(TAG, "failedToRecoverSession: network error. displaying error message...");
        homeView.displayHomefeedError(errorMessage);
    }


}
