package com.kelltontech.samplesplashscreenwithviewpagerapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.photos_viewpager);
        setupPager();
        pageSwitcher();
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager, true);
    }

    private void setupPager(){
        ViewPagerAdapters viewPagerAdapters = new ViewPagerAdapters(this);
        mViewPager.setAdapter(viewPagerAdapters);
    }

    public void pageSwitcher() {
        Timer timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, 2 * 1000); // delay for 2 second
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
//                        setupPager();
                       // mViewPager.setRotationY(180);
                        mViewPager.setCurrentItem(page,true);
                    } else{
                        page++;
                       // mViewPager.setRotationY(0);
                        mViewPager.setCurrentItem(page,true);
                    }
                }
            });

        }
    }
}
