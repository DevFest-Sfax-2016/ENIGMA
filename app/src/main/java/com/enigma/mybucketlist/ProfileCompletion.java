package com.enigma.mybucketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties

public class ProfileCompletion extends AppCompatActivity implements Serializable {

    private String good,bad,change,hobbies;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_completion);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        final String id =  firebaseUser.getUid();


        Button b = (Button) findViewById(R.id.buttonNext);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = (EditText) findViewById(R.id.editTextGoodTraits);
                good = txt.getText().toString();
                txt = (EditText) findViewById(R.id.editTextBadTraits);
                bad = txt.getText().toString();
                txt = (EditText) findViewById(R.id.editTextChange);
                change = txt.getText().toString();
                txt = (EditText) findViewById(R.id.editTextHobbies);
                hobbies = txt.getText().toString();
                Profile profile = new Profile(id,good,bad,change,hobbies);
                myRef.child("users").child(id).setValue(profile);


            }
        });
    }
}
