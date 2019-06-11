package com.example.talktome;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.layotu_parent);


        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        //animation drawable se animation
        animationDrawable.setEnterFadeDuration(3000); // araa hai , aanae ke liye 3 sec
        animationDrawable.setExitFadeDuration(1000); //jaaane ko 1 sec
        animationDrawable.start();


    }


    public void  play_btn(View view) {
        final Button sound = (Button) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,getResources().getIdentifier((String) sound.getTag(),"raw",getPackageName()));
       //mekia ka obj ,tresources capture kiya hai with tag name
        //resources capture
        mediaPlayer.start();
        //.start - play karne ko


        if (mediaPlayer.isPlaying()) {
            sound.setBackgroundColor(Color.RED);
            //play - red
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound.setBackgroundColor(Color.GREEN);
                //non playing hai toh green
                sound.setTextColor(Color.WHITE);
            }
        });

    }
}
//stop - mediaplayer

