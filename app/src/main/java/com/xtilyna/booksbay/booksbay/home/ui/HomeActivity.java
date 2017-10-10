package com.xtilyna.booksbay.booksbay.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Utils.BottomNavigationHelper;
import com.xtilyna.booksbay.booksbay.home.HomePresenter;
import com.xtilyna.booksbay.booksbay.home.HomePresenterImpl;
import com.xtilyna.booksbay.booksbay.login.ui.LoginActivity;
import com.xtilyna.booksbay.booksbay.newPost.ui.NewPostActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeView{

    private final static String TAG = "HomeActivity";

    private HomePresenter homePresenter;
    private BottomNavigationHelper bottomNavigationHelper;

    // UI References
    @BindView(R.id.create_a_post_fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.home_error_message) TextView errorMessage;
    @BindView(R.id.home_error_message_linearlayout) LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        homePresenter = new HomePresenterImpl(HomeActivity.this, getApplicationContext());
        bottomNavigationHelper = new BottomNavigationHelper(this);

    }

    @Override
    @OnClick(R.id.create_a_post_fab)
    public void createAPost() {
        homePresenter.createAPost();
//        Intent intent = new Intent(HomeActivity.this, NewPostActivity.class);
//        startActivity(intent);
    }

    @Override
    public void displayHomefeedError(String message) {
        fab.setVisibility(View.GONE);
        // recyclerview gone
        linearLayout.setVisibility(View.VISIBLE);
        errorMessage.setText(message);
    }

    @Override
    public void resetHomefeedError() {
        fab.setVisibility(View.VISIBLE);
        //revyvlerview visible
        linearLayout.setVisibility(View.GONE);
    }

    @Override
    public void navigateToLogin() {
        Intent i = new Intent(HomeActivity.this, LoginActivity.class);
        finish();
        startActivity(i);
    }

    @Override
    protected void onStop() {
        homePresenter.onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        homePresenter.onStart();
        super.onStart();
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
