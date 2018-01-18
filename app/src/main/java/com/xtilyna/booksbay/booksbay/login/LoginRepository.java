package com.xtilyna.booksbay.booksbay.login;


import com.xtilyna.booksbay.booksbay.entities.User;
import com.xtilyna.booksbay.booksbay.entities.UserAccountSettings;

public interface LoginRepository {

    void loginUser(String email, String password);
    void createLoginSession();
    User fetchUserInfo();
    UserAccountSettings fetchUserAccountSettings();

    void forgotPassword(String email);
}
