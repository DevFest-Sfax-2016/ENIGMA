package com.enigma.mybucketlist.Fragments;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.enigma.mybucketlist.Data.newSubmission;
import com.enigma.mybucketlist.HomePage;
import com.enigma.mybucketlist.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitXPFragment extends Fragment {


    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private View mView;

    public SubmitXPFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         mView=  inflater.inflate(R.layout.activity_submit_story, container, false);
        Button submmit = (Button) mView.findViewById(R.id.buttonSubmit);
        submmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                final String id =  firebaseUser.getUid();
                String description = ((TextView)mView.findViewById(R.id.editTextStory)).getText().toString();
                String Title = ((TextView)mView.findViewById(R.id.textViewTitle)).getText().toString();
                String TAG =  ((Spinner)mView.findViewById(R.id.spinnerstoryCategory)).getSelectedItem().toString();
                boolean anonym = ((CheckBox)mView.findViewById(R.id.checkBox)).isChecked();


                newSubmission submition = new newSubmission(description,Title,TAG,anonym);
                myRef.child("stories").child(id).setValue(submition);
                Fragment newFragment = new FeedFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();

            }
        });


        return mView;
    }

}
