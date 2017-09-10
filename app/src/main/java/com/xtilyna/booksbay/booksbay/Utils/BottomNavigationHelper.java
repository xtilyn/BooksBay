package com.xtilyna.booksbay.booksbay.Utils;


import android.content.Context;
import android.content.Intent;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.ui.HomeActivity;
import com.xtilyna.booksbay.booksbay.menu.ui.MenuActivity;

public class BottomNavigationHelper {

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

                break;
            case R.id.navigation_camera:

                break;
            case R.id.navigation_profile:

                break;
            case R.id.navigation_menu:
                intent = new Intent(context, MenuActivity.class);
                break;
        }
        if (intent != null) {
            context.startActivity(intent);
        }
    }

}
