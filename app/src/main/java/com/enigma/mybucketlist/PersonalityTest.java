package com.enigma.mybucketlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.enigma.mybucketlist.services.DataBaseAddClient;
import com.enigma.mybucketlist.services.DataBaseAddPersona;

public class PersonalityTest extends AppCompatActivity {
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);
        final Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.16personalities.com/free-personality-test";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        final Button button1 = (Button) findViewById(R.id.buttonNext);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner s = (Spinner) findViewById(R.id.spinnerChooseType);
                type = s.getSelectedItem().toString();
                new DataBaseAddPersona(type);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("personality",type);
                Intent intent = new Intent(getApplicationContext(),HomePage.class);
                startActivity(intent);


            }
        });
    }

}
