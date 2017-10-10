package com.xtilyna.booksbay.booksbay.login;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.login.events.LoginEvent;

import org.greenrobot.eventbus.EventBus;

public class LoginRepositoryImpl implements LoginRepository{

    private static final String TAG = "LoginRepositoryImpl";

    private Context context; // used for grabbing string resources

    public LoginRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public void loginUser(String email, String password) {
        Log.d(TAG, "logging in user...");
        try {
            final FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                            FirebaseUser user = auth.getCurrentUser();

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Log.w(TAG, "signInWithEmail:failed", task.getException());
                                if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                    postEvent(
                                            LoginEvent.ON_INVALID_USER_ERROR,
                                            context.getString(R.string.invalidUserErrorMessage));
                                } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    postEvent(
                                            LoginEvent.ON_INVALID_CREDENTIALS_ERROR,
                                            context.getString(R.string.invalidCredentialsErrorMessage));
                                } else {
                                    postEvent(
                                            LoginEvent.ON_SIGN_IN_ERROR,
                                            context.getString(R.string.signInErrorMessage));
                                }
                            } else {
                                try {
                                    if (user != null) {
                                        if (user.isEmailVerified()) {
                                            Log.d(TAG, "onComplete: success, email is verified. Creating login session for " +
                                                    user.getDisplayName() + " " + user.getEmail());

                                            createLoginSession();

                                        } else {
                                            postEvent(
                                                    LoginEvent.ON_EMAIL_UNVERIFIED_ERROR,
                                                    context.getString(R.string.emailNotVerifiedErrorMessage));
                                        }
                                    }
                                } catch (NullPointerException e) {
                                    Log.d(TAG, "onComplete: NullPointerException: " + e.getMessage());
                                }
                            }

                            // ...
                        }
                    });

        } catch (Exception e) {
            postEvent(LoginEvent.ON_SIGN_IN_ERROR, e.getMessage());
        }
    }

    @Override
    public void createLoginSession() {
        // TODO
    }

    private void postEvent(int type, String message) {
        LoginEvent event = new LoginEvent();
        event.setEventType(type);
        if (message != null) {
            event.setMessage(message);
        }

        EventBus eventBus = EventBus.getDefault();
        eventBus.post(event);
    }

}
