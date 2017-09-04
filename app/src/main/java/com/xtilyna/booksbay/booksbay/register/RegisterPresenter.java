package com.xtilyna.booksbay.booksbay.register;


import com.xtilyna.booksbay.booksbay.register.events.RegisterEvent;

public interface RegisterPresenter {

    void onStart();
    void onStop();

    void validateSectionOneFields(String displayName, String email, String password);
    void validatePasswordConfirmation(String password1, String password2);
    void registerNewUser(String location);

    void onEventMainThread(RegisterEvent event);

}
