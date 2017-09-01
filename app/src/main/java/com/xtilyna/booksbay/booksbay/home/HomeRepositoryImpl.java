package com.xtilyna.booksbay.booksbay.home;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.home.events.HomeEvent;

import org.greenrobot.eventbus.EventBus;

public class HomeRepositoryImpl implements HomeRepository{

    private final static String TAG = "HomeRepositoryImpl";

    private Context context; // used for grabbing strings resource

    // FIREBASE
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    HomeRepositoryImpl(Context context) {
        Log.d(TAG, "Created new HomeRepositoryImpl");
        this.context = context;
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
                    postEvent(HomeEvent.onUserNotLoggedInError, null);
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
    public void loadContent() {

        /*
        if else fails, postEvent(HomeEvent.onFailedToRecoverSession, context.getString(R.string.network_error_message));
         */
    }

    @Override
    public void createAPost() {


    }

    private void postEvent(int type, String errorMessage) {
        HomeEvent event = new HomeEvent();
        event.setEventType(type);
        if (errorMessage != null) {
            event.setErrorMessage(errorMessage);
        }

        EventBus eventBus = EventBus.getDefault();
        eventBus.post(event);
    }

}
