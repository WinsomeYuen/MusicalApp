package com.example.winsome.musicalapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Cover> mViewCover = new ArrayList<Cover>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, ArrayList<Cover> covers) {
        this.mInflater = LayoutInflater.from(context);
        mViewCover = covers;
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
        Cover currentCover = getItem(position);
        holder.myCover.setImageResource(currentCover.getmResourceImageId());
        holder.myTitle.setText(currentCover.getmTitle());
        holder.mySubtitle.setText(currentCover.getmSubtitle());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mViewCover.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView myCover;
        public TextView myTitle;
        public TextView mySubtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            myCover = itemView.findViewById(R.id.music_cover_image_view);
            myTitle = itemView.findViewById(R.id.title_text_view);
            mySubtitle = itemView.findViewById(R.id.subtitle_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context, MusicListActivity.class);
            context.startActivity(intent);
        }
    }

    // convenience method for getting data at click position
    public Cover getItem(int id) {
        return mViewCover.get(id);
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