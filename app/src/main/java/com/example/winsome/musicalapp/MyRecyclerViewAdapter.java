package com.example.winsome.musicalapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mViewCovers = Collections.emptyList();
    private List<String> mViewTitles = Collections.emptyList();
    private List<String> mViewSubs = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<Integer> covers, List<String> titles, List<String> subtitles) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewCovers = covers;
        this.mViewTitles = titles;
        this.mViewSubs = subtitles;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int image = mViewCovers.get(position);
        String title = mViewTitles.get(position);
        String subtitle = mViewSubs.get(position);
        holder.myCover.setImageResource(image);
        holder.myTitle.setText(title);
        holder.mySubtitle.setText(subtitle);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mViewTitles.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView myCover;
        public TextView myTitle;
        public TextView mySubtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            myCover = itemView.findViewById(R.id.musicCover);
            myTitle = itemView.findViewById(R.id.title);
            mySubtitle = itemView.findViewById(R.id.subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, MusiclistActivity.class);
            context.startActivity(intent);
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mViewTitles.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}