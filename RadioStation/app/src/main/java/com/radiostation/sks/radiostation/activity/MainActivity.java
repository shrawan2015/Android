package com.radiostation.sks.radiostation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radiostation.sks.radiostation.R;
import com.radiostation.sks.radiostation.fragment.DetailFragment;
import com.radiostation.sks.radiostation.fragment.MainFragment;
import com.radiostation.sks.radiostation.model.Station;

public class MainActivity extends AppCompatActivity {

    private  static  MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setMainActivity(this);
        android.app.FragmentManager fm = getFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if ( mainFragment == null ) {
            mainFragment = MainFragment.newInstance("blah" , "kah");
            fm.beginTransaction().add(R.id.container_main,mainFragment).commit();
        }


    }

    public void loadScreen(Station station){
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new DetailFragment()).addToBackStack(null).commit();
    }
}
