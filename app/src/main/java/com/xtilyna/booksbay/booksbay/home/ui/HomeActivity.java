package com.xtilyna.booksbay.booksbay.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.HomePresenter;
import com.xtilyna.booksbay.booksbay.home.HomePresenterImpl;
import com.xtilyna.booksbay.booksbay.newPost.ui.NewPostActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeView{


    private HomePresenter homePresenter;

    // UI References
    @BindView(R.id.create_a_post_fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        this.homePresenter = new HomePresenterImpl(HomeActivity.this);

    }

    @OnClick(R.id.create_a_post_fab)
    public void createAPost(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void createAPost() {
        Intent intent = new Intent(HomeActivity.this, NewPostActivity.class);
        startActivity(intent);
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
}
