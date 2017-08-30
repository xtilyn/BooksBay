package com.xtilyna.booksbay.booksbay.Register.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xtilyna.booksbay.booksbay.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterSectionTwo extends Fragment {

    // UI References
    @BindView(R.id.textview_register_event_message) TextView message;


    public RegisterSectionTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_section_two, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public void setRegisterEventMessage(String eventMessage) {
        message.setText(eventMessage);
    }

}
