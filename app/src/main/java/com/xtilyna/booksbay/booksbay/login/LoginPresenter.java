package com.xtilyna.booksbay.booksbay.login;


import com.xtilyna.booksbay.booksbay.login.events.LoginEvent;

public interface LoginPresenter {

    // methods for registering & unregistering eventbus
    void onStart();
    void onStop();

    void validateLogin(String email, String password);
    void onEventMainThread(LoginEvent event);

    void forgotPassword(String email);
}
