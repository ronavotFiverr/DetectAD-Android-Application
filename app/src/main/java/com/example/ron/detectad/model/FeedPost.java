package com.example.ron.detectad.model;

/**
 * Created by Ron on 6/23/2018.
 */

public class FeedPost {


    private String name;
    private String desc;
    private String ip;
    private String hash;

    public FeedPost() {
    }

    public FeedPost(String name, String desc, String ip, String hash) {
        this.name = name;
        this.desc = desc;
        this.ip = ip;
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
