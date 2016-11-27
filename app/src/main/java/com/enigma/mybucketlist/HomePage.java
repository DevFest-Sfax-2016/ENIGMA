package com.enigma.mybucketlist;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.enigma.mybucketlist.Fragments.FeedFragment;
import com.enigma.mybucketlist.Fragments.ProfileFragment;
import com.enigma.mybucketlist.Fragments.SearchFragment;
import com.enigma.mybucketlist.Fragments.SubmitXPFragment;
import com.enigma.mybucketlist.services.DataBaseAddClient;

import java.io.Serializable;

public class HomePage extends AppCompatActivity implements Serializable{

    private String[] array;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        new DataBaseAddClient();
        array  = getResources().getStringArray(R.array.menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.menu_item, array));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState == null) {

            Fragment newFragment = new FeedFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.main_fragment,newFragment).commit();
        }


    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {


        mDrawerList.setItemChecked(position, false);
        mDrawerLayout.closeDrawer(mDrawerList);

        Fragment newFragment;
        switch (position){
            case 0 :{
                newFragment = new FeedFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();
                break;
            }
            case 1 :{
                newFragment = new ProfileFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();
                break;
            }
            case 2:{
                newFragment = new SubmitXPFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();
                break;
            }
            case 3:{
                newFragment = new SearchFragment();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();
                break;
            }
            case 4: {
                signOut();
                break;
            }
            default:{
                newFragment = new FeedFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_fragment,newFragment).commit();
            }
        }


    }
    public void signOut(){

    }


}
