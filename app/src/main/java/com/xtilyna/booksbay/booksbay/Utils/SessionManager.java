package com.xtilyna.booksbay.booksbay.Utils;


import com.xtilyna.booksbay.booksbay.entities.User;
import com.xtilyna.booksbay.booksbay.entities.UserAccountSettings;

public interface SessionManager {

    void logoutUser();
    void createLoginSession(User user);
    void modifyUserAccountSettings(UserAccountSettings userAccountSettings);

}
