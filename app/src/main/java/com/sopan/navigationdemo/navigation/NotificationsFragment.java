package com.sopan.navigationdemo.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sopan.navigationdemo.R;

public class NotificationsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ask_notifications, container, false);

        return root;
    }
}