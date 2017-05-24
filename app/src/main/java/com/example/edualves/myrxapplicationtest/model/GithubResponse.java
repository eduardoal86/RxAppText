package com.example.edualves.myrxapplicationtest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by edualves on 21/05/17.
 */

public class GithubResponse implements Serializable{

    @SerializedName("name")
    String name;

    @SerializedName("bio")
    String bio;

    @SerializedName("avatar_url")
    String userPhotoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }
}
