package com.kolomyiaapp.android.places;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    MediaPlayer mPlayer;
    private SliderLayout mainScreenSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // play mp3
        mPlayer = MediaPlayer.create(this, R.raw.kolomyia);
        // set title
        getSupportActionBar().setTitle(R.string.app_name);
        // slider on main screen
        mainScreenSlider = (SliderLayout) findViewById(R.id.slider);
        // create image array
        ArrayList<Integer> sliderImages = new ArrayList<>();
        // add images to slider
        sliderImages.add(R.drawable.museum_pysanka);
        sliderImages.add(R.drawable.arch_ratusha1);
        sliderImages.add(R.drawable.monument_fedchyk2);
        sliderImages.add(R.drawable.arch_soborupc1);
        sliderImages.add(R.drawable.monumtnt_simpysanok2);
        sliderImages.add(R.drawable.arch_yosafata);
        sliderImages.add(R.drawable.monument_bandera);
        sliderImages.add(R.drawable.popukar_fomtanbazar);
        sliderImages.add(R.drawable.popular_miskeozero);

        for (int name : sliderImages) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
                    .image(name)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);
            mainScreenSlider.addSlider(defaultSliderView);
        }
        mainScreenSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mainScreenSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mainScreenSlider.setDuration(6000);
        mainScreenSlider.addOnPageChangeListener(this);
        // end of slider code
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * allow back and up/home button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * open tabs of lists on Location
     */
    public void ListBTN(View view) {
        Intent intent = new Intent(MainActivity.this, PlacesList.class);
        startActivity(intent);
    }

    /**
     * open routes on Routes
     */
    public void MapGoogle(View view) {
        Intent intent = new Intent(MainActivity.this, Routes.class);
        startActivity(intent);
    }

    /**
     * startAboutClass App
     */
    public void startAboutClass(MenuItem item) {
        Intent intentAbout = new Intent(MainActivity.this, AboutApp.class);
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

    /**
     * play music when pressed on logo
     */
    public void playMusicOnLogoClick(View view) {
        ImageView logo = (ImageView) findViewById(R.id.main_logo);
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
            logo.setImageResource(R.drawable.logo_main);
        } else {
            mPlayer.start();
            logo.setImageResource(R.drawable.logo_main_stop);
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
