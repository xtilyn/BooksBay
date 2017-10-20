package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.ui.HomeActivity;
import com.xtilyna.booksbay.booksbay.menu.ui.MenuActivity;
import com.xtilyna.booksbay.booksbay.messages.MessagesActivity;
import com.xtilyna.booksbay.booksbay.profile.ProfileActivity;

public class BottomNavigationHelper {

    public final static String TAG = "BottomNavigationHelper";

    public final static int NAV_HOME = 0;
    public final static int NAV_MESSAGES = 1;
    public final static int NAV_CAMERA = 2;
    public final static int NAV_PROFILE = 3;
    public final static int NAV_MENU = 4;

    private Context context;

    public BottomNavigationHelper(Context context) {
        this.context = context;
    }

    public int onNavigationButtonClick(int id) {
        Intent intent = null;
        int selectedItem;
        switch (id) {
            case R.id.navigation_home:
                intent = new Intent(context, HomeActivity.class);
                selectedItem = NAV_HOME;
                break;
            case R.id.navigation_messages:
                intent = new Intent(context, MessagesActivity.class);
                selectedItem = NAV_MESSAGES;
                break;
            case R.id.navigation_camera:
                Log.d(TAG, "on navigation camera clicked.");
                // TODO permission to access camera
                selectedItem = NAV_CAMERA;
                break;
            case R.id.navigation_profile:
                intent = new Intent(context, ProfileActivity.class);
                selectedItem = NAV_PROFILE;
                break;
            default: // navigation_menu
                intent = new Intent(context, MenuActivity.class);
                selectedItem = NAV_MENU;
                break;
        }
        if (intent != null) {
            context.startActivity(intent);
        }
        return selectedItem;
    }

}
