package com.xtilyna.booksbay.booksbay.Register;


import android.content.Context;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Register.events.RegisterEvent;
import com.xtilyna.booksbay.booksbay.Register.ui.RegisterView;
import com.xtilyna.booksbay.booksbay.Utils.EmailAddressValidator;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterRepository registerRepository;
    private RegisterView registerView;
    private Context context;

    private String displayName;
    private String email;
    private String password;
    private List<String> buyingCategories;
    private List<String> sellingCategories;


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

        this.displayName = displayName;
        this.email = email;
        this.password = password;

        registerView.goToRegisterSectionTwo();

    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    @Override
    public void validateSectionTwoFields() {

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
