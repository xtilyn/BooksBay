package com.xtilyna.booksbay.booksbay.Register.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xtilyna.booksbay.booksbay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterSectionOne extends Fragment {

    // UI References
    @BindView(R.id.edittext_display_name) EditText editTextDisplayName;
    @BindView(R.id.edittext_email) EditText editTextEmail;
    @BindView(R.id.edittext_password) EditText editTextPassword;
    @BindView(R.id.button_continue) Button buttonContinue;


    public RegisterSectionOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_section_one, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public String extractDisplayName() {
        return editTextDisplayName.getText().toString();
    }

    public String extractEmail() {
        return editTextEmail.getText().toString();
    }

    public String extractPassword() {
        return editTextPassword.getText().toString();
    }

    public void setEmailEdittextError(String errorMessage) {
        editTextEmail.setError(errorMessage);
        editTextEmail.requestFocus();
    }

    public void setDisplayNameEdittextError(String errorMessage) {
        editTextDisplayName.setError(errorMessage);
        editTextDisplayName.requestFocus();
    }

    public void setPasswordError(String errorMessage) {
        editTextPassword.setError(errorMessage);
        editTextPassword.requestFocus();
    }

    public void resetEdittextErrors() {
        editTextDisplayName.setError(null);
        editTextEmail.setError(null);
        editTextPassword.setError(null);
    }

}
