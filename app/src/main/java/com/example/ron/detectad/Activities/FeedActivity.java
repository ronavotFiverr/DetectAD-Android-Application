package com.example.ron.detectad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ron.detectad.R;
import com.example.ron.detectad.model.FeedPost;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    FeedPost post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        post = new FeedPost();
        listView = (ListView) findViewById(R.id.database_list_view);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("IOC");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.listview_layout,R.id.postInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    post = ds.getValue(FeedPost.class);
                    list.add("Name:"+post.getName().toString() + " ||Desc:" + post.getDesc().toString() + " ||IP:" + post.getIp().toString() + " ||Hash:"+ post.getHash().toString());
                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Post.class);
                startActivity(intent);
            }
        });
    }

}
