package com.example.winsome.musicalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener  {
    private RecyclerView recyclerView1, recyclerView2;
    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager horizontalLayoutManager;
    private ArrayList<Integer> cover = new ArrayList<>();
    private ArrayList<Integer> artist = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> subtitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        cover.add(R.mipmap.musiccover1);
        cover.add(R.mipmap.musiccover2);
        cover.add(R.mipmap.musiccover3);
        cover.add(R.mipmap.musiccover4);

        titles.add("Chaos");
        titles.add("Mic Drop");
        titles.add("IDFC");
        titles.add("Happy Little Pill");

        subtitles.add("Rich Brian");
        subtitles.add("BTS");
        subtitles.add("Blackbear");
        subtitles.add("Troye Sivan");

        artist.add(R.mipmap.musiccover9);
        artist.add(R.mipmap.musiccover5);
        artist.add(R.mipmap.musiccover7);
        artist.add(R.mipmap.musiccover10);


        // set up the RecyclerView
        recyclerView1 = (RecyclerView) findViewById(R.id.list1);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(MainActivity.this, cover, titles, subtitles);
        adapter.setClickListener(this);
        recyclerView1.setAdapter(adapter);

        recyclerView2 = (RecyclerView) findViewById(R.id.list2);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(MainActivity.this, artist, subtitles, titles);
        adapter.setClickListener(this);
        recyclerView2.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
