package com.xtilyna.booksbay.booksbay.login.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.register.ui.RegisterActivity;
import com.xtilyna.booksbay.booksbay.login.LoginPresenter;
import com.xtilyna.booksbay.booksbay.login.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private final static String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;

    // UI References
    @BindView(R.id.edittext_email) EditText editTextEmail;
    @BindView(R.id.edittext_password) EditText editTextPassword;
    @BindView(R.id.button_sign_in) Button buttonSignIn;
    @BindView(R.id.textview_register) TextView textViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.loginPresenter = new LoginPresenterImpl();
    }

    @OnClick(R.id.textview_register)
    public void goToRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


}
