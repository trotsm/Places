package com.kolomyiaapp.android.places;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    ImageView detailImage;
    TextView detailName;
    TextView detailDescription;
    ImageButton detailCoordinates;
    private SliderLayout detailSlider;
    TextToSpeech TTS;
    ImageButton TTSButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = (ImageView) findViewById(R.id.img_detail_activity);
        detailName = (TextView) findViewById(R.id.name_detail_activity);
        detailDescription = (TextView) findViewById(R.id.description_detail_activity);
        detailCoordinates = (ImageButton) findViewById(R.id.coordinates_detail_activity);
        detailSlider = (SliderLayout) findViewById(R.id.slider);

        // Get the Intent that starts this activity and extracts the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(RecyclerViewAdapter.EXTRA_NAME);
        String description = intent.getStringExtra(RecyclerViewAdapter.EXTRA_DESCRIPTION);
        final String coordinates = intent.getStringExtra(RecyclerViewAdapter.EXTRA_COORDINATES);
        // get image
        Bundle extras = getIntent().getExtras();
        int[] image = extras.getIntArray(RecyclerViewAdapter.EXTRA_SLIDER);
        // Capture the layout's TextView and set the string as its text
        detailName.setText(name);
        detailDescription.setText(description);
        // set images slider
        ArrayList<Integer> listImages = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            listImages.add(image[i]);
            Glide.with(this).load(listImages.get(i)).asBitmap().into(detailImage);
        }
        for (int img : listImages) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
                    .image(img)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);
            detailSlider.addSlider(defaultSliderView);
        }
        detailSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        detailSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        detailSlider.setDuration(4000);
        detailSlider.addOnPageChangeListener(this);
        // back(home) button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(name);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //set logo
                getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));
            }
        }
        // button to show google map
        ImageButton showMapButton = (ImageButton) findViewById(R.id.coordinates_detail_activity);
        showMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                String uri = String.format(Locale.ENGLISH, "https://maps.google.com/maps?daddr=%s", coordinates);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });

        TTSButton = (ImageButton) findViewById(R.id.readtext);
        // Text to Speech button
        TTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    TTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String utteranceId) {
                        }

                        @Override
                        public void onDone(String utteranceId) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something on UI thread
                                    startTextToSpeechOnClick();
                                }
                            });
                        }

                        @Override
                        public void onError(String utteranceId) {
                            Log.e("TAG", "error on " + utteranceId);
                        }
                    });
                    // set language to TTS
                    int result = TTS.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language is not supported");
                    } else {
                        TTSButton.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization Failed");
                }
            }
        });
        startTextToSpeechOnClick();
    }

    /**
     * Plays TextToSpeech when click button
     */
    public void startTextToSpeechOnClick() {
        TTSButton.setTag(1);
        TTSButton.setImageResource(R.mipmap.ic_play_text);

        TTSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer) v.getTag();
                if (TTS.isSpeaking()) {
                    if (TTS != null) {
                        TTS.stop();
                    }
                    TTSButton.setImageResource(R.mipmap.ic_play_text);
                    v.setTag(1); //pause
                } else {
                    if (status == 1) {
                        String words = detailDescription.getText().toString();
                        TTS.speak(words, TextToSpeech.QUEUE_FLUSH, null);
                        TTSButton.setImageResource(R.mipmap.ic_stop_text);
                        v.setTag(0); //stop
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (TTS != null) {
            TTS.shutdown();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (TTS != null) {
            TTS.stop();
        }
        startTextToSpeechOnClick();
    }

    /**
     * allow back and up/home button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * startAboutClass App
     */
    public void startAboutClass(MenuItem item) {
        Intent intentAbout = new Intent(DetailActivity.this, AboutApp.class);
        startActivity(intentAbout);
    }

    /**
     * startRateClass App
     */
    public void startRateClass(MenuItem item) {
        Uri webPage = Uri.parse("https://play.google.com/store/apps/details?id=com.kolomyiaapp.android.places");
        Intent intentRate = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(intentRate);
    }
}
