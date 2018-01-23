package com.xtilyna.booksbay.booksbay.menu;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.login.ui.LoginActivity;
import com.xtilyna.booksbay.booksbay.menu.events.MenuEvent;
import com.xtilyna.booksbay.booksbay.menu.ui.MenuView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MenuPresenterImpl implements MenuPresenter {

    private final static String TAG = "MenuPresenterImpl";

    private EventBus eventBus;

    private MenuView menuView;
    private MenuRepository menuRepository;

    private Context context;


    public MenuPresenterImpl(MenuView menuView, Context context) {
        this.menuView = menuView;
        this.context = context;
        this.eventBus = EventBus.getDefault();
        menuRepository = new MenuRepositoryImpl();
    }

    @Override
    public void onStart() {
        eventBus.register(this);
        menuRepository.onStart();
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        menuRepository.onStop();
    }

    @Override
    public void logoutUser() {
        // TODO clear all data from Shared Preferences (in this class or in menuRepo class):
        // editor.clear();
        // editor.commit();
        menuRepository.logoutUser();
    }

    @Override
    public void onSaveChangesButtonClick() {

    }

    @Override
    public void onEdittextChangeDetected() {

    }

    @Override
    @Subscribe
    public void onEventMainThread(MenuEvent menuEvent) {
        switch (menuEvent.getEventType()) {
            case MenuEvent.onLogoutUserEvent:
                menuView.navigateToRegister();
                break;
        }
    }

}
