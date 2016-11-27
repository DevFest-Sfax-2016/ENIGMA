package com.enigma.mybucketlist;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by mohamed on 11/27/16.
 */
@IgnoreExtraProperties

public class Profile {
    public String id,good,bad,change,hobbies;

    public Profile(String id, String good, String bad, String change, String hobbies) {
        this.id = id;
        this.good = good;
        this.bad = bad;
        this.change = change;
        this.hobbies = hobbies;

    }
}
