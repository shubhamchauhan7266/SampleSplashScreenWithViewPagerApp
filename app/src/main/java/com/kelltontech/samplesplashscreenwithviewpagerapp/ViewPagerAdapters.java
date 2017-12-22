package com.kelltontech.samplesplashscreenwithviewpagerapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by user on 21/12/17.
 */

public class ViewPagerAdapters extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments=new ArrayList<>();
    private ArrayList<String> tabTitles=new ArrayList<>();
    public ViewPagerAdapters(FragmentManager fm) {
        super(fm);
    }
    public void addFragments( Fragment fragments,String tabTitles)
    {
        this.fragments.add(fragments);
        this.tabTitles.add(tabTitles);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

}
