package com.example.ron.detectad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ron.detectad.R;



import com.rapidapi.rapidconnect.Argument;
import com.rapidapi.rapidconnect.RapidApiConnect;


import org.json.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class AppMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);


    }

    //Move to the Scan URL Activity
    //In order to check if the URL is malicious or safe to use
    public void scan_url_clicked(View view) {
        Intent intent = new Intent(this,ScanActivity.class);
        startActivity(intent);
    }

    //Move to Feed Activity
    //In order to check IOC (indication of compromise)
    public void feed_clicked(View view) {
        Intent intent = new Intent(this,FeedActivity.class);
        startActivity(intent);
    }
}
