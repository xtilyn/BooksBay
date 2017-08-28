package com.xtilyna.booksbay.booksbay.Register;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.Register.events.RegisterEvent;

import org.greenrobot.eventbus.EventBus;

public class RegisterRepositoryImpl implements RegisterRepository{

    private static final String TAG = "RegisterRepositoryImpl";
    private FirebaseAuth mAuth;

    private Context context;


    public RegisterRepositoryImpl(Context context) {
        mAuth = FirebaseAuth.getInstance();
        this.context = context;
    }

    @Override
    public void registerNewUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            postEvent(RegisterEvent.onFailedToRegisterError, context.getString(R.string.auth_failed));
                        }

                        postEvent(RegisterEvent.onRegisterSuccess, context.getString(R.string.email_verification_sent));
                    }
                });
    }

    @Override
    public void sendVerificationEmail() {

    }

    private void postEvent(int type, String message) {
        RegisterEvent event = new RegisterEvent();
        event.setEventType(type);
        if (message != null) {
            event.setErrorMessage(message);
        }

        EventBus eventBus = EventBus.getDefault();
        eventBus.post(event);
    }
}
