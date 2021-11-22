package com.example.imageslider;

import com.google.firebase.auth.FirebaseUser;

public class State {
    private static FirebaseUser user;

    public static void setUser(FirebaseUser user) {
        State.user = user;
    }
    public static FirebaseUser getUser(){
        return user;
    }
}
