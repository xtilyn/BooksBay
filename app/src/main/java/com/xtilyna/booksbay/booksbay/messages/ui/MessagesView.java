package com.xtilyna.booksbay.booksbay.messages.ui;


public interface MessagesView {

    void navigateToLogin(); // used by authStateListener: if user is not signed in, go to login page
    void displayMessagesError(String message);
    void resetMessageFeedError();

    void newMessage();
    void searchMessages();


}
