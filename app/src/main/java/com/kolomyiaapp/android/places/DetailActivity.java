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
    ImageView img_detail;
    TextView name_detail;
    TextView description_detail;
    ImageButton coordinates_deteil;
    private SliderLayout mDemoSlider;
    TextToSpeech tts;
    ImageButton ttsButton;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img_detail = (ImageView) findViewById(R.id.img_detail_activity);
        name_detail = (TextView) findViewById(R.id.name_detail_activity);
        description_detail = (TextView) findViewById(R.id.description_detail_activity);
        coordinates_deteil = (ImageButton) findViewById(R.id.coordinates_detail_activity);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(RecyclerViewAdapter.EXTRA_NAME);
        String description = intent.getStringExtra(RecyclerViewAdapter.EXTRA_DESCRIPTION);
        final String coordinates = intent.getStringExtra(RecyclerViewAdapter.EXTRA_COORDINATES);
        // get Image
        Bundle extras = getIntent().getExtras();
        int [] image = extras.getIntArray(RecyclerViewAdapter.EXTRA_SLIDER);
        // Capture the layout's TextView and set the string as its text
        name_detail.setText(name);
        description_detail.setText(description);
        ArrayList<Integer> listImages = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            listImages.add(image[i]);
            Glide.with(this).load(listImages.get(i)).asBitmap().into(img_detail);

        }

        for(int img : listImages){
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
                    .image(img)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            mDemoSlider.addSlider(defaultSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(name);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));
            }
        }

        // ініціюємо іміджбатон.
        ImageButton imageButton = (ImageButton)findViewById(R.id.coordinates_detail_activity);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Create a Uri from an intent string. Use the result to create an Intent.
                String uri = String.format(Locale.ENGLISH, "https://maps.google.com/maps?daddr=%s", coordinates);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
//                Uri gmmIntentUri = Uri.parse(coordinates);
//                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//// Make the Intent explicit by setting the Google Maps package
//                mapIntent.setPackage("com.google.android.apps.maps");
//
//// Attempt to start an activity that can handle the Intent
//                startActivity(mapIntent);
            }
        });




        ttsButton = (ImageButton) findViewById(R.id.readtext);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String utteranceId) {

                        }

                        @Override
                        public void onDone(String utteranceId) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // Do something on UI thread
                                    speak();
                                }
                            });
                        }

                        @Override
                        public void onError(String utteranceId) {
                            Log.e("TAG", "error on " + utteranceId);
                        }
                    });


                    int result = tts.setLanguage(Locale.getDefault());

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language is not supported");
                    } else {
                        ttsButton.setEnabled(true);
                    }

                } else {
                    Log.e("TTS", "Initialization Failed");
                }
            }
        });
        speak();
    }

    public void speak(){

        ttsButton.setTag(1);
        ttsButton.setImageResource(R.mipmap.ic_play_text);

        ttsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status =(Integer) v.getTag();
                if(tts.isSpeaking()){
                    if (tts != null) {
                        tts.stop(); }
                    ttsButton.setImageResource(R.mipmap.ic_play_text);
                    v.setTag(1); //pause
                }
                else {
                    if(status == 1) {
                        String words = description_detail.getText().toString();
                        tts.speak(words, TextToSpeech.QUEUE_FLUSH, null);
                        ttsButton.setImageResource(R.mipmap.ic_stop_text);
                        v.setTag(0); //stop
                    }

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(tts != null){
            tts.shutdown();
        }
    }


    @Override
    protected void onStop()
    {
        super.onStop();

        if(tts != null){
            tts.stop();
        }
        speak();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
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
    public void About(MenuItem item) {
        Intent intentAbout = new Intent(DetailActivity.this, About_App.class);
        startActivity(intentAbout);
    }

    public void Rate(MenuItem item) {

        Uri webpage = Uri.parse("https://play.google.com/store/apps/details?id=com.kolomyiaapp.android.places");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }
}
