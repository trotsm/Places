package com.kolomyiaapp.android.places;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {
    TextView aboutAppInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__app);

        aboutAppInfo = (TextView) findViewById(R.id.main_text);
        //set information about app
        aboutAppInfo.setText(R.string.aboutapp);
        // add clickable URLs
        Linkify.addLinks(aboutAppInfo, Linkify.WEB_URLS);
        aboutAppInfo.setLinkTextColor(Color.parseColor("#e03a3e"));
        // add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("  Про додаток");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));
        }
    }

    /**
     * allow back and up/home button
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            //end the activity
            this.finish();
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sends letter to an email
     */
    public void sendALetter(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:appkolomyia@gmail.com "));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }
}
