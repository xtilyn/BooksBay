package com.xtilyna.booksbay.booksbay.register;


import android.content.Context;
import android.util.Log;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.register.events.RegisterEvent;
import com.xtilyna.booksbay.booksbay.register.ui.RegisterView;
import com.xtilyna.booksbay.booksbay.Utils.EmailAddressValidator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RegisterPresenterImpl implements RegisterPresenter {

    private final static String TAG = "RegisterPresenterImpl";

    private EventBus eventBus;
    private RegisterRepository registerRepository;
    private RegisterView registerView;

    // Used for grabbing strings resource
    private Context context;

    private String displayName;
    private String email;
    private String password;


    public RegisterPresenterImpl(RegisterView registerView, Context context) {
        this.eventBus = EventBus.getDefault();
        this.registerView = registerView;
        this.context = context;
        registerRepository = new RegisterRepositoryImpl(context);
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
    public void validateSectionOneFields(String displayName, String email, String password) {

        if (displayName.isEmpty()) {
            registerView.setDisplayNameEdittextError(context.getString(R.string.field_required_error));
            return;
        }
        if (email.isEmpty()) {
            registerView.setEmailEdittextError(context.getString(R.string.field_required_error));
            return;
        }
        if (password.isEmpty()) {
            registerView.setPasswordError(context.getString(R.string.field_required_error));
            return;
        }
        if (!EmailAddressValidator.isEmailValid(email)) {
            registerView.setEmailEdittextError(context.getString(R.string.invalid_email_error));
            return;
        }
        if (!isPasswordValid(password)) {
            registerView.setPasswordError(context.getString(R.string.invalid_password_error));
            return;
        }

        this.displayName = displayName;
        this.email = email;
        this.password = password;

        // everything else is valid:
        registerView.resetEdittextErrors();
        registerView.showConfirmPasswordDialog();

    }

    @Override
    public void validatePasswordConfirmation(String password1, String password2) {
        if (password1.equals(password2)) {
            registerView.dismissConfirmPasswordDialog();
            registerView.showSetLocationDialog();
        } else {
            registerView.onPasswordsDontMatch();
        }
    }

    @Override
    public void registerNewUser(String location) {
        registerView.showProgress(true);
        registerRepository.registerNewUser(email, password, displayName, location);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    @Subscribe
    @Override
    public void onEventMainThread(RegisterEvent event) {
        registerView.showProgress(false);
        if (event.getEventType() == RegisterEvent.onRegisterSuccess) {
            Log.d(TAG, "onEventMainThread: register success.");
            registerView.onRegisterSuccess();
        }
        else {
            Log.d(TAG, "onEventMainThread: register unsuccessful");
            registerView.onRegisterUnsuccessful(event.getMessage());
        }
    }
}
