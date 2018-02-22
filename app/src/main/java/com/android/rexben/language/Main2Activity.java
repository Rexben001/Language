package com.android.rexben.language;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioMAnager;

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS) {
               releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        mAudioMAnager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One", "Okan", R.mipmap.ic_launcher, R.raw.baby));
        words.add(new Word("Two", "meji", R.mipmap.ic_launcher_round, R.raw.automatic_camera));
        words.add(new Word("three", "meta", R.mipmap.ic_launcher, R.raw.mainp));
        words.add(new Word("four", "merin", R.mipmap.ic_launcher, R.raw.multiple_click));
        words.add(new Word("five", "marun", R.mipmap.ic_launcher_round, R.raw.mindg));
        words.add(new Word("six", "mefa", R.mipmap.ic_launcher_round, R.raw.mainp));
        words.add(new Word("seven", "meje", R.mipmap.ic_launcher_round, R.raw.mindg));
        words.add(new Word("eight", "mejo", R.mipmap.ic_launcher_round, R.raw.automatic_camera));
        words.add(new Word("nine", "mesan", R.mipmap.ic_launcher, R.raw.automatic_camera));
        words.add(new Word("ten", "mewa", R.mipmap.ic_launcher, R.raw.baby));


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.seaGreen);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();

                int result = mAudioMAnager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(Main2Activity.this, word.getAudiResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioMAnager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

}

