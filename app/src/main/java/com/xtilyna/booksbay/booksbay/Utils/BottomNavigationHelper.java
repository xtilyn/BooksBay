package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.ui.HomeActivity;
import com.xtilyna.booksbay.booksbay.menu.ui.MenuActivity;
import com.xtilyna.booksbay.booksbay.messages.ui.MessagesActivity;
import com.xtilyna.booksbay.booksbay.profile.ui.ProfileActivity;

public class BottomNavigationHelper {

    public final static String TAG = "BottomNavigationHelper";

    private Context context;

    public BottomNavigationHelper(Context context) {
        this.context = context;
    }

    public void onNavigationButtonClick(int id) {
        Intent intent = null;
        switch (id) {
            case R.id.navigation_home:
                intent = new Intent(context, HomeActivity.class);
                break;
            case R.id.navigation_messages:
                intent = new Intent(context, MessagesActivity.class);
                break;
            case R.id.navigation_camera:
                Log.d(TAG, "on navigation camera clicked.");
                // TODO permission to access camera
                break;
            case R.id.navigation_profile:
                intent = new Intent(context, ProfileActivity.class);
                break;
            default: // navigation_menu
                intent = new Intent(context, MenuActivity.class);
                break;
        }
        if (intent != null) {
            context.startActivity(intent);
        }
    }

}
