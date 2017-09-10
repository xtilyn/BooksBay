package com.xtilyna.booksbay.booksbay.menu;


import com.xtilyna.booksbay.booksbay.menu.events.MenuEvent;

public interface MenuPresenter {

    void onStart();
    void onStop();

    void logoutUser();
    void onSaveChangesButtonClick();
    void onEdittextChangeDetected();
    void onEventMainThread(MenuEvent menuEvent);

}
