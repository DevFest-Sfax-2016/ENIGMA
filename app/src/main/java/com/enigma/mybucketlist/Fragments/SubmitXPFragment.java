package com.enigma.mybucketlist.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enigma.mybucketlist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitXPFragment extends Fragment {


    public SubmitXPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit_x, container, false);
    }

}
