package com.xtilyna.booksbay.booksbay.login.ui;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
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

public class LoginActivity extends AppCompatActivity implements LoginView{

    private final static String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;

    // UI References
    @BindView(R.id.edittext_email) TextInputEditText editTextEmail;
    @BindView(R.id.edittext_password) TextInputEditText editTextPassword;
    @BindView(R.id.textview_register) TextView textViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.loginPresenter = new LoginPresenterImpl(this, getApplicationContext());
        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == R.id.login || i == EditorInfo.IME_NULL) {
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();
                    loginPresenter.validateLogin(email, password);
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.textview_register)
    public void goToRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_sign_in)
    public void onSignInButtonClick() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        loginPresenter.validateLogin(email, password);
    }

    @Override
    public void showProgress(boolean show) {
        // TODO
        // toggle disable inputs as needed
    }

    @Override
    public void resetEdittextErrors() {

    }

    @Override
    public void setEmailEdittextError(String errorMessage) {

    }

    @Override
    public void setPasswordError(String errorMessage) {

    }

    private void disableInputs(boolean disable) {

    }

}
