package com.example.ron.detectad.model;

/**
 * Created by Ron on 5/29/2018.
 */

public class user {
    public String username;


    public user() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public user(String username) {
        this.username = username;
    }
}
