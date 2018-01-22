package com.xtilyna.booksbay.booksbay.register.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.login.ui.LoginActivity;
import com.xtilyna.booksbay.booksbay.register.RegisterPresenter;
import com.xtilyna.booksbay.booksbay.register.RegisterPresenterImpl;
import com.xtilyna.booksbay.booksbay.Utils.NonSwipeableViewPager;
import com.xtilyna.booksbay.booksbay.Utils.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RegisterView {

    private RegisterPresenter registerPresenter;
    private RegisterSectionOne registerSectionOne;

    // UI References
    @BindView(R.id.viewpager_register)
    NonSwipeableViewPager viewPager;

    private Dialog confirmPasswordDialog;
    private Dialog setLocationDialog;

    // UI in dialogs
    EditText confirmPasswordEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        registerPresenter = new RegisterPresenterImpl(this, getApplicationContext());
        setupViewPager();
        initDialogs();

    }

    @Override
    protected void onStart() {
        registerPresenter.onStart();
        super.onStart();
    }

    @Override
    protected void onStop() {
        registerPresenter.onStop();
        super.onStop();
    }

    private void setupViewPager() {
        registerSectionOne = new RegisterSectionOne();

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(registerSectionOne);
        adapter.addFragment(new RegisterSectionTwo());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void initDialogs() {
        confirmPasswordDialog = new Dialog(this);
        confirmPasswordDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        confirmPasswordDialog.setContentView(R.layout.dialog_confirm_password);
        confirmPasswordEdittext = confirmPasswordDialog.findViewById(R.id.edittext_dialog_password);
        confirmPasswordEdittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == R.id.button_dialog_confirm_password || i == EditorInfo.IME_NULL) {
                    extractAndValidatePasswords();
                    return true;
                }
                return false;
            }
        });

        setLocationDialog = new Dialog(this);
        setLocationDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setLocationDialog.setContentView(R.layout.dialog_set_location);
    }

    /**
     * On click listener for continue button in register section one fragment.
     *
     * @param view view
     */
    public void onSectionOneContinuteButtonClick(View view) {
        registerPresenter.validateSectionOneFields(
                registerSectionOne.extractDisplayName(),
                registerSectionOne.extractEmail(),
                registerSectionOne.extractPassword()

        );
    }

    /**
     * On click listener for continue button in confirm password dialog.
     * Checks if the entered passwords are the same.
     *
     * @param view continue button
     */
    public void onConfirmPasswordButtonClick(View view) {
        extractAndValidatePasswords();
    }

    /**
     * On click listener for set location button in set location dialog.
     * @param view set location button
     */
    public void onSetLocationButtonClick(View view) {
        // TODO placeholder user location...
        String location = "Calgary, AB";
        dismissSetLocationDialog();
        registerPresenter.registerNewUser(location);
    }

    private void extractAndValidatePasswords() {
        String password1 = registerSectionOne.extractPassword();
        String password2 = confirmPasswordEdittext.getText().toString();
        registerPresenter.validatePasswordConfirmation(password1, password2);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            registerSectionOne.showProgress(true);
        } else {
            registerSectionOne.showProgress(false);
        }
    }

    @Override
    public void disableInputs(boolean disable) {
        // TODO
        // if (disable) {...}
    }

    @Override
    public void resetEdittextErrors() {
        registerSectionOne.resetEdittextErrors();
    }

    @Override
    public void setEmailEdittextError(String errorMessage) {
        registerSectionOne.setEmailEdittextError(errorMessage);
    }

    @Override
    public void setDisplayNameEdittextError(String errorMessage) {
        registerSectionOne.setDisplayNameEdittextError(errorMessage);
    }

    @Override
    public void setPasswordError(String errorMessage) {
        registerSectionOne.setPasswordError(errorMessage);
    }

    @Override
    public void showConfirmPasswordDialog() {
        confirmPasswordDialog.show();
    }

    @Override
    public void showSetLocationDialog() {
        setLocationDialog.show();
    }

    @Override
    public void dismissConfirmPasswordDialog() {
        confirmPasswordDialog.dismiss();
    }

    @Override
    public void dismissSetLocationDialog() {
        setLocationDialog.dismiss();
    }

    @Override
    public void onRegisterSuccess() {
        // Hide virtual keyboard
        // Check if no view has focus:
        View view = RegisterActivity.this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        viewPager.setCurrentItem(1);
        Toast.makeText(this, getString(R.string.sign_up_successful), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterUnsuccessful(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordsDontMatch() {
        confirmPasswordEdittext.setError(getString(R.string.passwords_dont_match));
        confirmPasswordEdittext.requestFocus();
    }

    @OnClick(R.id.sign_in_btn)
    public void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
