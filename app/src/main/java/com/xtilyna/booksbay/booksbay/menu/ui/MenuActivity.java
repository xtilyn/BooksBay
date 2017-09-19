package com.xtilyna.booksbay.booksbay.menu.ui;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Utils.BottomNavigationHelper;
import com.xtilyna.booksbay.booksbay.menu.MenuPresenter;
import com.xtilyna.booksbay.booksbay.menu.MenuPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity implements MenuView {

    //    private List<MenuItem> recyclerviewData;
    private MenuPresenter menuPresenter;
    private BottomNavigationHelper bottomNavigationHelper;

    // UI references
//    @BindView(R.id.recyclerview_menu) RecyclerView recyclerView;

    private AlertDialog confirmLogoutDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
//
//        recyclerviewData = new ArrayList<>();
//        RecyclerViewHelper.setupRecyclerView(
//                getApplicationContext(),
//                recyclerView,
//                RecyclerViewHelper.linearVertical,
//                new MenuAdapter(this, recyclerviewData),
//                recyclerviewData
//        );

        menuPresenter = new MenuPresenterImpl(this, getApplicationContext());
        bottomNavigationHelper = new BottomNavigationHelper(this);
        setupDialogs();

    }

    private void setupDialogs() {
        confirmLogoutDialog = new AlertDialog.Builder(MenuActivity.this).create();
        confirmLogoutDialog.setTitle(getString(R.string.confirm_logout));
        confirmLogoutDialog.setMessage(getString(R.string.confirm_logout_message));
        confirmLogoutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.log_out),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        menuPresenter.logoutUser();
                    }
                });
    }

    /**
     * On click listener for the logout button
     */
    @OnClick(R.id.button_logout_menu)
    public void onLogoutButtonClick() {
        confirmLogoutDialog.show();
    }

    @Override
    public void showSaveChangesButton(boolean show) {

    }

    @Override
    public void saveProfileChanges() {

    }

    /**
     * On click listener for navigation view
     * @param view navigation button
     */
    @OnClick({
            R.id.navigation_home,
            R.id.navigation_messages,
            R.id.navigation_camera,
            R.id.navigation_profile,
            R.id.navigation_menu})
    public void onNavigationButtonClick(View view) {
        bottomNavigationHelper.onNavigationButtonClick(view.getId());
    }
}
