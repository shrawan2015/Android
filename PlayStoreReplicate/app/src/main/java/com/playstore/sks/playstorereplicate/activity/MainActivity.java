package com.playstore.sks.playstorereplicate.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.playstore.sks.playstorereplicate.R;
import com.playstore.sks.playstorereplicate.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fragmentManager.findFragmentById(R.id.main_container_view);
        if ( mainFragment  == null) {
            mainFragment = new MainFragment();
            fragmentManager.beginTransaction().add(R.id.main_container_view,mainFragment).commit();
        }
    }
}
