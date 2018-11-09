package com.kolomyiaapp.android.places;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class Routes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        // add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.routes);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_logo));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            //ends the activity
            this.finish();
        return super.onOptionsItemSelected(item);
    }

    public void Memorials(View view) {
        Uri webpage = Uri.parse("https://goo.gl/maps/eRyBZgbMKNA2");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void Churches(View view) {
        Uri webpage = Uri.parse("https://tinyurl.com/yb9lassw");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void Museums(View view) {
        Uri webpage = Uri.parse("https://goo.gl/maps/ST3gvCrYdwu");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}
