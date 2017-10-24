package com.xtilyna.booksbay.booksbay.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.xtilyna.booksbay.booksbay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    // UI references
    @BindView(R.id.navigation_profile) ImageView navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        navProfile.setImageResource(R.drawable.ic_profile_color_accent);
    }
}
