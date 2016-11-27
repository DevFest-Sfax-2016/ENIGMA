package com.enigma.mybucketlist.services;

import android.util.Log;

import com.enigma.mybucketlist.Data.newUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by houcem on 27/11/16.
 */
@IgnoreExtraProperties

public class DataBaseAddClient implements Serializable {


    // Write a message to the database
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    public DataBaseAddClient(){



        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();


        //profile.put("name",mFirebaseUser.getDisplayName());
        Log.e("who",mFirebaseUser.getEmail());


        newUser user = new newUser(mFirebaseUser.getEmail(),mFirebaseUser.getUid());
        myRef.child("users").child(mFirebaseUser.getUid()).setValue(user);

        //profile.put("image",mFirebaseUser.getPhotoUrl().toString());


    }


    }



