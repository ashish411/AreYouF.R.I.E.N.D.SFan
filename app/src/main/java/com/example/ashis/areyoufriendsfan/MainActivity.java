package com.example.ashis.areyoufriendsfan;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button_start;
     MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mp=  MediaPlayer.create(this,R.raw.theme_song);
        mp.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView_rplay);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/ufonts.com_gabriel-weiss-friends-font.ttf");
        textView.setTypeface(typeface);
        button_start=(Button) findViewById(R.id.button_start);
        button_start.setTypeface(typeface);
       button_start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mp.stop();
               Intent intent = new Intent(getApplicationContext(),FirstPage.class);
               startActivity(intent);
               finish();
           }
       });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();

    }
}

