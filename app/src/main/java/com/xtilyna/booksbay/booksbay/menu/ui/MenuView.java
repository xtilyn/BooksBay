package com.xtilyna.booksbay.booksbay.menu.ui;


public interface MenuView {

    void navigateToRegister(); // if user is not signed in, go to login page

    void showSaveChangesButton(boolean show);
    void saveProfileChanges();

}
