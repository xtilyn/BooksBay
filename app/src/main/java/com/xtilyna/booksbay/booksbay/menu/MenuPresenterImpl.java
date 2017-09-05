package com.xtilyna.booksbay.booksbay.menu;


import com.google.firebase.auth.FirebaseAuth;

public class MenuPresenterImpl implements MenuPresenter{

    private FirebaseAuth mAuth;


    public MenuPresenterImpl() {
        // TODO initialize firebase auth
    }

    @Override
    public void logoutUser() {
        mAuth.signOut();
    }

    @Override
    public void onSaveChangesButtonClick() {

    }

    @Override
    public void onEdittextChangeDetected() {

    }
}
