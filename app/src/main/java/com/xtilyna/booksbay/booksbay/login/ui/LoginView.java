package com.xtilyna.booksbay.booksbay.login.ui;


public interface LoginView {

    void showProgress(boolean show);

    void resetEdittextErrors();
    void setEmailEdittextError(String errorMessage);
    void setPasswordError(String errorMessage);

}
