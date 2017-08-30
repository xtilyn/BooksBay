package com.xtilyna.booksbay.booksbay.Register;


import android.content.Context;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Register.events.RegisterEvent;
import com.xtilyna.booksbay.booksbay.Register.ui.RegisterView;
import com.xtilyna.booksbay.booksbay.Utils.EmailAddressValidator;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterRepository registerRepository;
    private RegisterView registerView;
    private Context context;


    public RegisterPresenterImpl(RegisterView registerView, Context context) {
        this.registerView = registerView;
        this.context = context;
        registerRepository = new RegisterRepositoryImpl(context);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void registerNewUser() {

    }

    @Override
    public void goToRegisterSectionTwo() {

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

        // if everything else is valid:
        registerView.resetEdittextErrors();

        registerRepository.registerNewUser(email, password); // TODO register displayName

    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


    @Subscribe
    @Override
    public void onEventMainThread(RegisterEvent event) {
        registerView.displayRegisterEventMessage(event.getMessage());
        if (event.getEventType() == RegisterEvent.onRegisterSuccess) {
            registerView.onRegisterSuccess();
        }
    }
}
