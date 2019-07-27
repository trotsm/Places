package com.kolomyiaapp.android.places;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PlacesList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);

        tabsPager tabsPager = new tabsPager(getSupportFragmentManager());

        //add fragments
        tabsPager.addFragment(new FragmentPopular(), getString(R.string.popular));
        tabsPager.addFragment(new FragmentMonument(), getString(R.string.monuments));
        tabsPager.addFragment(new FragmentArchitecture(), getString(R.string.architecture));
        tabsPager.addFragment(new FragmentReligion(), getString(R.string.religion));
        tabsPager.addFragment(new FragmentMuseum(), getString(R.string.museums));

        viewPager.setOffscreenPageLimit(tabsPager.getCount() - 1); // download all fragments at the same time once it is created

        viewPager.setAdapter(tabsPager);
        tabLayout.setupWithViewPager(viewPager);

        // add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.places_list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    /**
     * allow back and up/home button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            //ends the activity
            this.finish();
        return super.onOptionsItemSelected(item);
    }

    /**
     * startAboutClass App
     */
    public void startAboutClass(MenuItem item) {
        Intent intentAbout = new Intent(PlacesList.this, AboutApp.class);
        startActivity(intentAbout);
    }

    /**
     * startRateClass App
     */
    public void startRateClass(MenuItem item) {
        Uri webPage = Uri.parse("https://play.google.com/store/apps/details?id=com.kolomyiaapp.android.places");
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(intent);
    }
}

