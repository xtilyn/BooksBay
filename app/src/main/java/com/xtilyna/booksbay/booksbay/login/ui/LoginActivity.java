package com.xtilyna.booksbay.booksbay.login.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.login.LoginPresenter;
import com.xtilyna.booksbay.booksbay.login.LoginPresenterImpl;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private final static String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;

    // UI References



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.loginPresenter = new LoginPresenterImpl();
    }
}
