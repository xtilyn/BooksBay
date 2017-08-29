package com.xtilyna.booksbay.booksbay.Register.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Register.RegisterPresenter;
import com.xtilyna.booksbay.booksbay.Register.RegisterPresenterImpl;
import com.xtilyna.booksbay.booksbay.Utils.NonSwipeableViewPager;
import com.xtilyna.booksbay.booksbay.Utils.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RegisterView{


    private RegisterPresenter registerPresenter;
    private RegisterSectionOne registerSectionOne;
    private RegisterSectionTwo registerSectionTwo;

    // UI References
    @BindView(R.id.viewpager_register) NonSwipeableViewPager viewPager;
    @BindView(R.id.textview_register_event_message) TextView textViewRegisterEventMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        registerPresenter = new RegisterPresenterImpl(this, getApplicationContext());
        setupViewPager();

    }

    private void setupViewPager() {
        registerSectionOne = new RegisterSectionOne();
        registerSectionTwo = new RegisterSectionTwo();

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(registerSectionOne);
        adapter.addFragment(registerSectionTwo);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    /**
     * On click listener for continue button in register section one fragment.
     * @param view view
     */
    public void onSectionOneContinuteButtonClick(View view) {
        registerPresenter.validateSectionOneFields(
                registerSectionOne.extractDisplayName(),
                registerSectionOne.extractEmail(),
                registerSectionOne.extractPassword()

        );
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {}

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 1)
            viewPager.setCurrentItem(0);
        else
            super.onBackPressed();
    }

    @Override
    public void showProgress(boolean show) {
        // TODO
    }

    @Override
    public void goToRegisterSectionTwo() {
        viewPager.setCurrentItem(1);
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
    public void displayRegisterEventMessage(String eventMessage) {
        viewPager.setVisibility(View.GONE);
        textViewRegisterEventMessage.setText(eventMessage);
        textViewRegisterEventMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRegisterSuccess() {
        // TODO displayMessage on register section two fragment
        Toast.makeText(this, getString(R.string.new_account_created), Toast.LENGTH_LONG).show();
    }

}
