package com.xtilyna.booksbay.booksbay.register.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.register.RegisterPresenter;
import com.xtilyna.booksbay.booksbay.register.RegisterPresenterImpl;
import com.xtilyna.booksbay.booksbay.Utils.NonSwipeableViewPager;
import com.xtilyna.booksbay.booksbay.Utils.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RegisterView{


    private RegisterPresenter registerPresenter;
    private RegisterSectionOne registerSectionOne;

    // UI References
    @BindView(R.id.viewpager_register) NonSwipeableViewPager viewPager;


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

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(registerSectionOne);
        adapter.addFragment(new RegisterSectionTwo());

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
                registerSectionOne.extractPassword(),
                registerSectionOne.extractLocation()

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
    public void onRegisterSuccess() {
        viewPager.setCurrentItem(1);
        Toast.makeText(this, getString(R.string.sign_up_successful), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterUnsuccessful(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

}
