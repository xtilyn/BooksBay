package com.xtilyna.booksbay.booksbay.login.ui;


import com.xtilyna.booksbay.booksbay.entities.User;

public interface LoginView {

    void showProgress(boolean show);

    void setEmailEdittextError(String errorMessage);
    void setPasswordError(String errorMessage);

    void showErrorToast(String message);
    void navigateToHomeActivity();

}
