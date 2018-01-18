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
    private static final String PREF_NAME = "ChristilynPref.BooksBay";

    // All Shared Preferences Keys
    public static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    public static final String KEY_USERID = "userId";

    // user account settings data
    public static final String KEY_LOCATION = "location";
    public static final String KEY_WEBSITES = "websites";

    // Constructor
    public SessionManagerImpl(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    @Override
    public void logoutUser() {
// Clearing all data from Shared Preferences
        editor = pref.edit();
        editor.clear();
        editor.apply();

    }

    @Override
    public void createLoginSession(User user) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, user.getDisplay_name());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_USERID, user.getUserID());
        editor.putString(KEY_LOCATION, user.getLocation());
        editor.apply();
    }

    @Override
    public void modifyUserAccountSettings(UserAccountSettings userAccountSettings) {
        editor = pref.edit();
        editor.putString(KEY_WEBSITES, userAccountSettings.getWebsites());
        editor.apply();
    }

}
