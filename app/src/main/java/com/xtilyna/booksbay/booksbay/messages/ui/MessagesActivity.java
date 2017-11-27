package com.xtilyna.booksbay.booksbay.messages.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.xtilyna.booksbay.booksbay.R;
import com.xtilyna.booksbay.booksbay.login.ui.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessagesActivity extends AppCompatActivity implements MessagesView{

    // UI references
    @BindView(R.id.navigation_messages) ImageView navMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        ButterKnife.bind(this);
        navMessages.setImageResource(R.drawable.ic_chat_color_accent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void navigateToLogin() {
        Intent i = new Intent(MessagesActivity.this, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // finish current activity
        finish();
        startActivity(i);
    }

    @Override
    public void displayMessagesError(String message) {

    }

    @Override
    public void resetMessageFeedError() {

    }

    @Override
    public void newMessage() {

    }

    @Override
    public void searchMessages() {

    }
}
