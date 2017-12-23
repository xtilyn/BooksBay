package com.xtilyna.booksbay.booksbay.profile.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.login.ui.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileView{

    // UI references
    @BindView(R.id.navigation_profile) ImageView navProfile;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        navProfile.setImageResource(R.drawable.ic_profile_color_accent);

        // get profile info from onSaveInstanceState
        String username = "user.name";

        toolbar.setTitle(username);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO save user profile details
    }

    @Override
    public void navigateToLogin() {
        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // finish current activity
        finish();
        startActivity(i);
    }

    @Override
    public void displayProfileError(String message) {

    }

    @Override
    public void resetProfileError() {

    }

    @Override
    public void createAPost() {

    }
}
