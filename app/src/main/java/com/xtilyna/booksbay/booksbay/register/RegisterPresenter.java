package com.xtilyna.booksbay.booksbay.register;


import com.xtilyna.booksbay.booksbay.register.events.RegisterEvent;

public interface RegisterPresenter {

    void onStart();
    void onStop();

    void validateSectionOneFields(String displayName, String email, String password, String location);

    void onEventMainThread(RegisterEvent event);

}
