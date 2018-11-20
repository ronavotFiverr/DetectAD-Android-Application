package com.example.ron.detectad.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ron.detectad.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AppMainActivityFragment extends Fragment {

    public AppMainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_main, container, false);
    }
}
