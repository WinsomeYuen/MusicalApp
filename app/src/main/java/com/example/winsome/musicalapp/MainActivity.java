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
    private ArrayList<Cover> cover = new ArrayList<>();
    private ArrayList<Cover> artist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with

        cover.add(new Cover("Chaos","Rich Brian",R.mipmap.musiccover1, R.raw.bensounddubstep));
        cover.add(new Cover("Mic Drop","BTS", R.mipmap.musiccover2, R.raw.bensounddubstep));
        cover.add(new Cover("IDFC","Blackbear", R.mipmap.musiccover3, R.raw.bensounddubstep));
        cover.add(new Cover("Happy Little Pill","Troye Sivan", R.mipmap.musiccover4, R.raw.bensounddubstep));


        artist.add(new Cover("Rich Brian", "Chaos",R.mipmap.musiccover1, R.raw.bensounddubstep));
        artist.add(new Cover("BTS", "Mic Drop",R.mipmap.musiccover2, R.raw.bensounddubstep));
        artist.add(new Cover("Blackbear", "IDFC",R.mipmap.musiccover3, R.raw.bensounddubstep));
        artist.add(new Cover("Troye Sivan", "Happy Little Pill",R.mipmap.musiccover4, R.raw.bensounddubstep));

        // set up the RecyclerView
        recyclerView1 = (RecyclerView) findViewById(R.id.list1);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(MainActivity.this, cover);
        adapter.setClickListener(this);
        recyclerView1.setAdapter(adapter);

        recyclerView2 = (RecyclerView) findViewById(R.id.list2);
        horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(MainActivity.this, artist);
        adapter.setClickListener(this);
        recyclerView2.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
