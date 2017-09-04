package com.xtilyna.booksbay.booksbay.register.ui;


public interface RegisterView {

    void showProgress(boolean show);
    void disableInputs(boolean disable);

    void resetEdittextErrors();
    void setEmailEdittextError(String errorMessage);
    void setDisplayNameEdittextError(String errorMessage);
    void setPasswordError(String errorMessage);

    void showConfirmPasswordDialog();
    void showSetLocationDialog();
    void dismissConfirmPasswordDialog();
    void dismissSetLocationDialog();

    void onRegisterSuccess();
    void onRegisterUnsuccessful(String errorMessage);
    void onPasswordsDontMatch();

}
