package com.android.rexben.language;

/**
 * Created by Rexben on 2/15/2018.
 */

public class Word {

    private String mDefaultTrans;
    private String mYorTrans;
    private int mImageResourceId = HAS_NO_IMAGE;
    private static final int HAS_NO_IMAGE = -1;
    private int mAudiResourceId;

    public Word(String defaultTrans, String yorTrans, int audio) {
        mDefaultTrans = defaultTrans;
        mYorTrans = yorTrans;
        mAudiResourceId = audio;
    }

    public Word(String defaultTrans, String yorTrans, int imageResourceId, int audio) {
        mDefaultTrans = defaultTrans;
        mYorTrans = yorTrans;
        mImageResourceId = imageResourceId;
        mAudiResourceId = audio;
    }

    public String getDefaultTrans() {
        return mDefaultTrans;
    }

    public String getYorTrans() {
        return mYorTrans;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != HAS_NO_IMAGE;
    }

    public int getAudiResourceId() {
        return mAudiResourceId;
    }
}
