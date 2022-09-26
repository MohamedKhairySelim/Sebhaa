package com.Tasbeh.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.sebhaa.R;

public class SplashScreen extends AppCompatActivity {
    MediaPlayer mediaplayer;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView=findViewById(R.id.SplashImage);
        imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.animation));

        mediaplayer=new MediaPlayer();
        //Splash_Screen code
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            SplashScreen.this.finish();
        },5000);
        //Media player code
        mediaplayer=MediaPlayer.create(SplashScreen.this,R.raw.quran);
        mediaplayer.start();
    }
}
