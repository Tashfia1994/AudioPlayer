package com.tashfia.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnplay,btnpause,btnstop;
    MediaPlayer player;
    boolean playing=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplay=(Button)findViewById(R.id.btn_play);
        btnpause=(Button)findViewById(R.id.btn_pause);
        btnstop=(Button)findViewById(R.id.btn_stop);

        player=MediaPlayer.create(MainActivity.this,R.raw.audio);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playing)
                {
                    player.start();
                    playing=true;
                }
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (playing){
                    player.pause();
                    playing=false;
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playing){
                    player.stop();
                    playing=false;
                }

                MainActivity.this.finish();
            }
        });
    }
}
