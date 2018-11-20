package com.example.ron.detectad.Activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ron.detectad.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class FeedActivityFragment extends Fragment {


    public FeedActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);

    }
}
