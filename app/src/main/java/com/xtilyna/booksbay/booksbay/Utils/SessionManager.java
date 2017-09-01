package com.xtilyna.booksbay.booksbay.Utils;


import com.xtilyna.booksbay.booksbay.entities.User;
import com.xtilyna.booksbay.booksbay.entities.UserAccountSettings;

public interface SessionManager {

    void logoutUser();
    void createLoginSession();
    void modifyUserAccountSettings(UserAccountSettings userAccountSettings);
    void modifyUserInformation(User user);

}
