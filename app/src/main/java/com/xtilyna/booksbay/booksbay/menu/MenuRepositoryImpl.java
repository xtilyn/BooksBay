package com.xtilyna.booksbay.booksbay.menu;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.xtilyna.booksbay.booksbay.menu.events.MenuEvent;

import org.greenrobot.eventbus.EventBus;

public class MenuRepositoryImpl implements MenuRepository {

    private final static String TAG = "MenuRepositoryImpl";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    public MenuRepositoryImpl() {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out. Navigating to LoginActivity...");
                    postEvent(MenuEvent.onLogoutUserEvent, null);
                }
                // ...
            }
        };
    }

    @Override
    public void onStart() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void logoutUser() {
        mAuth.signOut();
    }

    @Override
    public void fetchUserAccountSettings() {
        // TODO
    }

    private void postEvent(int eventType, String eventMessage) {
        MenuEvent event = new MenuEvent();
        event.setEventType(eventType);
        if (eventMessage != null) {
            event.setMessage(eventMessage);
        }

        EventBus eventBus = EventBus.getDefault();
        eventBus.post(event);
    }
}
