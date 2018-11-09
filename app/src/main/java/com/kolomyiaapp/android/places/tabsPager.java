package com.kolomyiaapp.android.places;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class tabsPager extends FragmentPagerAdapter {
    //need to define a variable that hold the size of Android Tablayout tabs and update the constructor to include that variable.
    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    // PageAdapter constructor is use to communicate between this class and MainActivity.java.
    public tabsPager(FragmentManager fm) {
        super(fm);
    }
    //getItem is where will be initialized the fragments for Android TabLayout.
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }
    // getCount will return the number of tabs that will appear in Android TabLayout.
    @Override
    public int getCount() {
        return lstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        lstFragment.add(fragment);
        lstTitles.add(title);
    }

}
