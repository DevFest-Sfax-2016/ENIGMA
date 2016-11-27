package com.enigma.mybucketlist.Data;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by houcem on 27/11/16.
 */

@IgnoreExtraProperties
public class newUser {
    public String email;
    public String ID;

    public newUser(String email, String ID) {
        this.email = email;
        this.ID = ID;
    }
}