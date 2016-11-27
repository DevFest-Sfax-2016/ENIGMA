package com.enigma.mybucketlist.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.enigma.mybucketlist.Profile;
import com.enigma.mybucketlist.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
@IgnoreExtraProperties
public class ProfileFragment extends Fragment implements Serializable {


    private String good,bad,change,hobbies;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    View mView;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView =inflater.inflate(R.layout.activity_profile_completion, container, false);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        final String id =  firebaseUser.getUid();


        Button b = (Button) mView.findViewById(R.id.buttonNext);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txt = (EditText) mView.findViewById(R.id.editTextGoodTraits);
                good = txt.getText().toString();
                txt = (EditText) mView.findViewById(R.id.editTextBadTraits);
                bad = txt.getText().toString();
                txt = (EditText) mView.findViewById(R.id.editTextChange);
                change = txt.getText().toString();
                txt = (EditText) mView.findViewById(R.id.editTextHobbies);
                hobbies = txt.getText().toString();
                Profile profile = new Profile(id,good,bad,change,hobbies);
                myRef.child("users").child(id).setValue(profile);


            }
        });
        return mView;
    }

}
