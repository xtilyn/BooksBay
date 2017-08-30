package com.xtilyna.booksbay.booksbay.Register;


import com.xtilyna.booksbay.booksbay.Register.events.RegisterEvent;

import java.util.List;

public interface RegisterPresenter {

    void onStart();
    void onStop();

    void registerNewUser();
    void goToRegisterSectionTwo();
    void validateSectionOneFields(String displayName, String email, String password);

    void onEventMainThread(RegisterEvent event);

}
