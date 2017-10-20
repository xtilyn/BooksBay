package com.xtilyna.booksbay.booksbay.login.ui;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.ui.HomeActivity;
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
    @BindView(R.id.button_login) Button buttonLogin;
    @BindView(R.id.progressbar_login) ProgressBar progressBarLogin;


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

    @Override
    protected void onStart() {
        loginPresenter.onStart();
        super.onStart();
    }

    @Override
    protected void onStop() {
        loginPresenter.onStop();
        super.onStop();
    }

    @OnClick(R.id.textview_register)
    public void goToRegisterActivity() {
        Log.d(TAG, "goToRegisterActivity: navigating to register activity...");
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_login)
    public void onSignInButtonClick() {
        Log.d(TAG, "onSignInButtonClick: validating credentials...");
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        loginPresenter.validateLogin(email, password);
    }

    @OnClick(R.id.textview_forgot_password)
    public void onForgotPasswordClick() {
        Log.d(TAG, "onForgotPasswordClick: sending email to reset password...");
        String email = editTextEmail.getText().toString();
        loginPresenter.forgotPassword(email);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            disableInputs(true);
            progressBarLogin.setVisibility(View.VISIBLE);
        } else {
            disableInputs(false);
            progressBarLogin.setVisibility(View.GONE);
        }
    }

    @Override
    public void setEmailEdittextError(String errorMessage) {
        editTextEmail.setError(errorMessage);
        editTextEmail.requestFocus();
    }

    @Override
    public void setPasswordError(String errorMessage) {
        editTextPassword.setError(errorMessage);
        editTextPassword.requestFocus();
    }

    @Override
    public void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        // Closing all the Activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        startActivity(intent);
    }

    private void disableInputs(boolean disable) {
        if (disable) {
            editTextPassword.setEnabled(false);
            editTextEmail.setEnabled(false);
            textViewRegister.setEnabled(false);
            buttonLogin.setEnabled(false);
        } else {
            editTextPassword.setEnabled(true);
            editTextEmail.setEnabled(true);
            textViewRegister.setEnabled(true);
            buttonLogin.setEnabled(true);
        }
    }

}
