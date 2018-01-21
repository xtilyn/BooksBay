package com.xtilyna.booksbay.booksbay.login;


import  android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Utils.EmailAddressValidator;
import com.xtilyna.booksbay.booksbay.Utils.SessionManagerImpl;
import com.xtilyna.booksbay.booksbay.login.events.LoginEvent;
import com.xtilyna.booksbay.booksbay.login.ui.LoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
        Log.d(TAG, "onStart: eventbus registered");
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        Log.d(TAG, "onStop: eventbus unregistered");
}

    @Override
    public void validateLogin(String email, String password) {

        if (TextUtils.isEmpty(email)) {
            loginView.setEmailEdittextError(context.getString(R.string.field_required_error));
            return;
        }
        if (TextUtils.isEmpty(password)) {
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
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        loginView.showProgress(false);
        if (event.getEventType() == LoginEvent.ON_LOGIN_SUCCESS) {
            loginView.navigateToHomeActivity();
        } else {
            loginView.showErrorToast(event.getMessage());
        }
    }

    @Override
    public void forgotPassword(String email) {
        if (TextUtils.isEmpty(email)) {
            loginView.setEmailEdittextError(context.getString(R.string.please_enter_email));
            return;
        }
        loginRepository.forgotPassword(email);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}
