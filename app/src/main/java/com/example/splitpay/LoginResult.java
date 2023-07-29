package com.example.splitpay;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    @SerializedName(("userid"))
    private String userid;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("photo")
    private String photoUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
