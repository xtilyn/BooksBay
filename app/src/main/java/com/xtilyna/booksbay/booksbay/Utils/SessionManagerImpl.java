package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.xtilyna.booksbay.booksbay.entities.User;
import com.xtilyna.booksbay.booksbay.entities.UserAccountSettings;

public class SessionManagerImpl implements SessionManager {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    private static final String TAG = "SessionManager";

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref.BooksBay";

    // All Shared Preferences Keys
    public static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // Constructor
    public SessionManagerImpl(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        // editor = pref.edit();
    }

    @Override
    public void logoutUser() {
// Clearing all data from Shared Preferences
        //editor.clear();
        //editor.commit();

    }

    @Override
    public void createLoginSession() {
        // TODO save all user settings
    }

    @Override
    public void modifyUserAccountSettings(UserAccountSettings userAccountSettings) {

    }

    @Override
    public void modifyUserInformation(User user) {

    }
}
