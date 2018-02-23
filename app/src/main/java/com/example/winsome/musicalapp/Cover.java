package com.example.winsome.musicalapp;

public class Cover {
    private String title;
    private String subtitle;
    private int mResourceImageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Cover(String mainT, String subT, int imageId, int audioResourceId) {
        title = mainT;
        subtitle = subT;
        mResourceImageId = imageId;
        mAudioResourceId = audioResourceId;
    }

    public String getmTitle() {
        return title;
    }

    public String getmSubtitle() {return subtitle;}

    public int getmResourceImageId() {
        return mResourceImageId;
    }

    public boolean hasImage() {
        return mResourceImageId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

}
