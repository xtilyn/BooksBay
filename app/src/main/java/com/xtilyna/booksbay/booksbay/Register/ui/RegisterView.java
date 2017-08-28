package com.xtilyna.booksbay.booksbay.Register.ui;


public interface RegisterView {

    void showProgress(boolean show);
    void goToRegisterSectionTwo();

    void resetEdittextErrors();
    void setEmailEdittextError(String errorMessage);
    void setDisplayNameEdittextError(String errorMessage);
    void setPasswordError(String errorMessage);

    void displayRegisterEventMessage(String eventMessage);
    void onRegisterSuccess();

}
