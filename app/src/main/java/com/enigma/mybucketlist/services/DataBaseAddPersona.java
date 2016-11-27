package com.enigma.mybucketlist.services;

import com.enigma.mybucketlist.Data.newUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by houcem on 27/11/16.
 */
@IgnoreExtraProperties
public class DataBaseAddPersona implements Serializable {


    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;


    public DataBaseAddPersona(String persona) {
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();


        myRef.child("users").child(mFirebaseUser.getUid()).child("personality").setValue(persona);
    }
}
