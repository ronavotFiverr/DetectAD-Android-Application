package com.example.ron.detectad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ron.detectad.R;
import com.example.ron.detectad.model.FeedPost;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
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

    public void post_clicked(View view) {

        //Variables to store textView text
        TextView nameTxt;
        TextView descTxt;
        TextView ipTxt;
        TextView hashTxt;

        //Find and grab the text from each TextView in the View
        nameTxt = (TextView)findViewById(R.id.nameTxt);
        String name =  nameTxt.getText().toString();

        descTxt = (TextView)findViewById(R.id.descTxt);
        String desc =  descTxt.getText().toString();

        ipTxt = (TextView)findViewById(R.id.ipTxt);
        String ip =  ipTxt.getText().toString();

        hashTxt = (TextView)findViewById(R.id.hashTxt);
        String hash =  hashTxt.getText().toString();

        //Create new "Post" type of variable in order to store the date from the TextView
        FeedPost post = new FeedPost(name,desc,ip,hash);


        //Random a number in order to generate "unique" number of firebase child
        Random rand = new Random();

        //1000 is the maximum and the 1 is our minimum
        int  n = rand.nextInt(1000) + 1;

        //Saving the data in Firebase in the reference: IOC -> child -> ...
        FirebaseDatabase.getInstance().getReference("IOC").child( String.valueOf(n)).setValue(post);

        //Move back to the Feed automaticlly and see the update feed.
        Intent intent = new Intent(this,FeedActivity.class);
        startActivity(intent);
    }
}
