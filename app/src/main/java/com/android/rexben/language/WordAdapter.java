package com.android.rexben.language;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by Rexben on 2/15/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;


    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mColorResourceId = color;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main2, parent, false);

        }
            Word currentWord = getItem(position);

        TextView yTextView = (TextView) listItemView.findViewById(R.id.tv);
        yTextView.setText(currentWord.getYorTrans());

        TextView DTextView = (TextView) listItemView.findViewById(R.id.tv2);
        DTextView.setText(currentWord.getDefaultTrans());

        ImageView mImageView = (ImageView) listItemView.findViewById(R.id.imageView);
        if (currentWord.hasImage()) {
            mImageView.setImageResource(currentWord.getImageResourceId());
            mImageView.setVisibility(View.VISIBLE);
        }else {
            mImageView.setVisibility(View.GONE);
        }
        View container = listItemView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        container.setBackgroundColor(color);

        return listItemView;
    }
}
