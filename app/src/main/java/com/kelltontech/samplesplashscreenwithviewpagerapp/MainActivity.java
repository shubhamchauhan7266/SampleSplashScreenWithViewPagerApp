package com.kelltontech.samplesplashscreenwithviewpagerapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapters mViewPagerAdapter;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.photos_viewpager);
        mViewPagerAdapter = new ViewPagerAdapters(this);
        mViewPager.setAdapter(mViewPagerAdapter);
        pageSwitcher(2);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager, true);
    }

    public void pageSwitcher(int seconds) {
        Timer timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page == 3){     // In my case the number of pages are 3
                        page = 0;
                        mViewPager.setRotationY(180);
                        mViewPager.setCurrentItem(page,true);
                    } else{
                        page++;
                        mViewPager.setRotationY(0);
                        mViewPager.setCurrentItem(page,true);
                    }
                }
            });

        }
    }
}
