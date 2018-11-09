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
    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //play mp3
        mPlayer = MediaPlayer.create(this, R.raw.kolomyia);

        getSupportActionBar().setTitle(R.string.app_name);
        // getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));

//        FadingTextView fadingTextView = (FadingTextView) findViewById(R.id.text);
//        fadingTextView.setTimeout(FadingTextView.SECONDS, 2);

        //slider

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        ArrayList<Integer> file_maps = new ArrayList<>();
        file_maps.add(R.drawable.museum_pysanka);
        file_maps.add(R.drawable.arch_ratusha1);
        file_maps.add(R.drawable.monument_fedchyk2);
        file_maps.add(R.drawable.arch_soborupc1);
        file_maps.add(R.drawable.monumtnt_simpysanok2);
        file_maps.add(R.drawable.arch_yosafata);
        file_maps.add(R.drawable.monument_bandera);
        file_maps.add(R.drawable.popukar_fomtanbazar);
        file_maps.add(R.drawable.popular_miskeozero);




        for(int name : file_maps){
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
//                    .description(name)
                    .image(name)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            mDemoSlider.addSlider(defaultSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setDuration(6000);
        mDemoSlider.addOnPageChangeListener(this);

        // end or slider

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ListBTN(View view) {
        Intent intent = new Intent(MainActivity.this, PlacesList.class);
        startActivity(intent);
    }

    public void MapGoogle(View view) {
//        Uri webpage = Uri.parse("https://www.google.com/maps/dir/48.5242568,25.045635/%D0%9C%D1%83%D0%B7%D0%B5%D0%B9+%D0%9F%D0%B8%D1%81%D0%B0%D0%BD%D0%BA%D0%B0,+%D0%BF%D1%80%D0%BE%D1%81%D0%BF%D0%B5%D0%BA%D1%82+%D0%92'%D1%8F%D1%87%D0%B5%D1%81%D0%BB%D0%B0%D0%B2%D0%B0+%D0%A7%D0%BE%D1%80%D0%BD%D0%BE%D0%B2%D0%BE%D0%BB%D0%B0,+%D0%9A%D0%BE%D0%BB%D0%BE%D0%BC%D0%B8%D1%8F,+%D0%86%D0%B2%D0%B0%D0%BD%D0%BE-%D0%A4%D1%80%D0%B0%D0%BD%D0%BA%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/%D0%9C%D1%83%D0%B7%D0%B5%D0%B9+%D0%93%D1%83%D1%86%D1%83%D0%BB%D1%8C%D1%89%D0%B8%D0%BD%D0%B8+%D1%96+%D0%9F%D0%BE%D0%BA%D1%83%D1%82%D1%82%D1%8F,+%D0%B2%D1%83%D0%BB%D0%B8%D1%86%D1%8F+%D0%A2%D0%B5%D0%B0%D1%82%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D0%B0,+%D0%9A%D0%BE%D0%BB%D0%BE%D0%BC%D0%B8%D1%8F,+%D0%86%D0%B2%D0%B0%D0%BD%D0%BE-%D0%A4%D1%80%D0%B0%D0%BD%D0%BA%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/%D0%97%D0%B0%D0%BB%D1%96%D0%B7%D0%BD%D0%B8%D1%87%D0%BD%D0%B8%D0%B9+%D0%B2%D0%BE%D0%BA%D0%B7%D0%B0%D0%BB+%D0%BC.+%D0%9A%D0%BE%D0%BB%D0%BE%D0%BC%D0%B8%D1%8F,+%D0%BF%D0%BB%D0%BE%D1%89%D0%B0+%D0%9F%D1%80%D0%B8%D0%B2%D0%BE%D0%BA%D0%B7%D0%B0%D0%BB%D1%8C%D0%BD%D0%B0,+%D0%9A%D0%BE%D0%BB%D0%BE%D0%BC%D0%B8%D1%8F,+%D0%86%D0%B2%D0%B0%D0%BD%D0%BE-%D0%A4%D1%80%D0%B0%D0%BD%D0%BA%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C,+78200/48.5242568,25.045635/@48.5297267,25.0313645,14z/am=t/data=!3m1!4b1!4m24!4m23!1m1!4e1!1m5!1m1!1s0x4736d285800292ad:0x890607c5962ed2e7!2m2!1d25.0391091!2d48.5284027!1m5!1m1!1s0x4736d28f9f70de83:0xd89cff65ea4dee7d!2m2!1d25.0376651!2d48.5287725!1m5!1m1!1s0x4736cd67b6cb58f3:0x2f8117793254900e!2m2!1d25.0600831!2d48.53443!1m1!4e1!3e2/");
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//        startActivity(intent);

        Intent intent = new Intent(MainActivity.this, Routes.class);
        startActivity(intent);

    }

    public void About(MenuItem item) {
        Intent intentAbout = new Intent(MainActivity.this, About_App.class);
        startActivity(intentAbout);
    }

    public void Rate(MenuItem item) {

        Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.kolomyiaapp.android.places");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }

    public void Play(View view) {
        ImageView button = (ImageView) findViewById(R.id.main_logo);
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
            button.setImageResource(R.drawable.logo_main);
        } else {
            mPlayer.start();
            button.setImageResource(R.drawable.logo_main_stop);
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
