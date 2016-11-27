package com.enigma.mybucketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.enigma.mybucketlist.services.DataBaseAddClient;

import java.io.Serializable;

public class HomePage extends AppCompatActivity implements Serializable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
                                   DataBaseAddClient add = new DataBaseAddClient();

    }
}
