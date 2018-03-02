package com.xtilyna.booksbay.booksbay.register;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.entities.User;
import com.xtilyna.booksbay.booksbay.entities.UserAccountSettings;
import com.xtilyna.booksbay.booksbay.register.events.RegisterEvent;

import org.greenrobot.eventbus.EventBus;

public class RegisterRepositoryImpl implements RegisterRepository{

    private static final String TAG = "RegisterRepositoryImpl";

    private Context context; // used for grabbing string resources


    RegisterRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public void registerNewUser(final String email, String password, final String displayName, final String location) {

        try {
            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            // TODO display cause(s) of unsuccessful task (instanceof <FirebaseException>)
                            if (!task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail: " + task.getException());
                                postEvent(RegisterEvent.onFailedToRegisterError, context.getString(R.string.auth_failed) + task.getException().getMessage());
                            } else if (task.isSuccessful()){
                                Log.d(TAG, "createUserWithEmail: onComplete: sign up successful. Sending verification email...");
                                sendVerificationEmail(email, displayName, location);
                            }
                        }
                    });
        } catch (Exception e) {
            postEvent(RegisterEvent.onFailedToRegisterError, e.getMessage());
        }

    }

    @Override
    public void sendVerificationEmail(final String email, final String displayName, final String location) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (!task.isSuccessful()) {
                                postEvent(RegisterEvent.onVerificationEmailError, context.getString(R.string.email_verification_error));
                            } else {
                                Log.d(TAG, "sendVerificationEmail: email verification sent.");
                                postEvent(RegisterEvent.onRegisterSuccess, context.getString(R.string.email_verification_sent));
                                addNewUserAccountSettings(email, displayName, location);
                            }
                        }
                    });
        }
    }

    private void addNewUserAccountSettings(final String email, final String displayName, final String location) {
        Log.d(TAG, "addNewUserAccountSettings: adding user account settings to database...");
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            final String userID = firebaseUser.getUid();
            final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            User user = new User(userID, email, displayName, location);
            reference.child(context.getString(R.string.users))
                    .child(userID)
                    .setValue(user);

            UserAccountSettings settings = new UserAccountSettings(" ");
            reference.child(context.getString(R.string.user_account_settings))
                    .child(userID)
                    .setValue(settings);

            FirebaseAuth.getInstance().signOut();
        }

    }

    private void postEvent(int type, String message) {
        RegisterEvent event = new RegisterEvent();
        event.setEventType(type);
        if (message != null) {
            event.setMessage(message);
        }

        EventBus eventBus = EventBus.getDefault();
        eventBus.post(event);
    }
}
