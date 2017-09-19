package com.xtilyna.booksbay.booksbay.login;


import android.content.Context;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Utils.EmailAddressValidator;
import com.xtilyna.booksbay.booksbay.login.events.LoginEvent;
import com.xtilyna.booksbay.booksbay.login.ui.LoginView;

import org.greenrobot.eventbus.EventBus;

public class LoginPresenterImpl implements LoginPresenter{

    private final static String TAG = "LoginPresenterImpl";

    private EventBus eventBus;
    private LoginRepository loginRepository;
    private LoginView loginView;

    // Used for grabbing strings resource
    private Context context;

    public LoginPresenterImpl(LoginView loginView, Context context) {
        this.eventBus = EventBus.getDefault();
        this.loginView = loginView;
        this.context = context;
        loginRepository = new LoginRepositoryImpl(context);
    }

    @Override
    public void onStart() {
        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
    }

    @Override
    public void validateLogin(String email, String password) {

        if (email.isEmpty()) {
            loginView.setEmailEdittextError(context.getString(R.string.field_required_error));
            return;
        }
        if (password.isEmpty()) {
            loginView.setPasswordError(context.getString(R.string.field_required_error));
            return;
        }
        if (!EmailAddressValidator.isEmailValid(email)) {
            loginView.setEmailEdittextError(context.getString(R.string.invalid_email_error));
            return;
        }
        if (!isPasswordValid(password)) {
            loginView.setPasswordError(context.getString(R.string.invalid_password_error));
            return;
        }

        loginView.showProgress(true);
        loginRepository.loginUser(email, password);

    }

    @Override
    public void onEventMainThread(LoginEvent event) {
        loginView.showProgress(false);
        // TODO
        // if login success, create new login session
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}
