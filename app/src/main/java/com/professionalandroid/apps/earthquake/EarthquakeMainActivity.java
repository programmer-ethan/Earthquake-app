package com.professionalandroid.apps.earthquake;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EarthquakeMainActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT ="TAG_LIST_FRAGMENT";

    EarthquakeListFragment mEarthquakeListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_main);

        FragmentManager fm = getSupportFragmentManager();

        if(savedInstanceState==null){
            FragmentTransaction ft = fm.beginTransaction();

            mEarthquakeListFragment = new EarthquakeListFragment();
            ft.add(R.id.main_activity_frame, mEarthquakeListFragment, TAG_LIST_FRAGMENT);

            ft.commitNow();
        } else {
            mEarthquakeListFragment = (EarthquakeListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }
        Date now = Calendar.getInstance().getTime();
        List<Earthquake> dummyQuakes = new ArrayList<Earthquake>(0);
        dummyQuakes.add(new Earthquake("0",now, "san Jose", null, 7.3, null));
        dummyQuakes.add(new Earthquake("1",now, "LA", null, 6.5, null));

        mEarthquakeListFragment.setEarthquakes(dummyQuakes);
    }
}