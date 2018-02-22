package com.example.winsome.musicalapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MusiclistActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        final ArrayList<Cover> covers = new ArrayList<Cover>();
        covers.add(new Cover("Airplanes", "Hayley Williams ft. Tinie Tempah",R.drawable.musiccover5));
        covers.add(new Cover("I fall apart", "Post Malone",R.drawable.musiccover6));
        covers.add(new Cover("Do re mi", "Blackbear",R.drawable.musiccover1));
        covers.add(new Cover("Unforgettable", "French Montana",R.drawable.musiccover10));
        covers.add(new Cover("Every time we touch", "Hayley Williams ft. Tinie Tempeh",R.drawable.musiccover2));
        CoverAdapter adapter = new CoverAdapter(this, covers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
