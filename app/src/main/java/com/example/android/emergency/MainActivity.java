package com.example.android.emergency;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.view.Gravity;
import android.view.View;

        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.media.MediaPlayer;
        import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);

        // sets up MediaPlayer for the siren sound

        final MediaPlayer sirenSound = MediaPlayer.create(this, R.raw.siren1);
        sirenSound.setLooping(true);
        Button playSiren = this.findViewById(R.id.siren);

        // button press plays the siren sound, pressing button again stops

        playSiren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Turn up volume!";
                int duration = Toast.LENGTH_SHORT;
                if(sirenSound.isPlaying())
                    sirenSound.pause();
                else
                    sirenSound.start();
                Toast toast = Toast.makeText(context, text, duration); toast.show();
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 500);
            }
        });
        final MediaPlayer whistle = MediaPlayer.create(this, R.raw.police_whistle);
        whistle.setLooping(true);
        Button playWhistle = this.findViewById(R.id.whistle);

        // button press plays the whistle sound, pressing button again stops

        playWhistle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Turn up volume!";
                int duration = Toast.LENGTH_SHORT;
                if(whistle.isPlaying())
                    whistle.pause();
                else
                    whistle.start();
                Toast toast = Toast.makeText(context, text, duration); toast.show();
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 500);
            }
        });

        final MediaPlayer sendHelp = MediaPlayer.create(this, R.raw.sendhelp);
        sendHelp.setLooping(true);
        Button playSendHelp = this.findViewById(R.id.help);

        // button press plays the send help sound, pressing button again stops

        playSendHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Turn up volume!";
                int duration = Toast.LENGTH_SHORT;
                if(sendHelp.isPlaying())
                    sendHelp.pause();
                else
                    sendHelp.start();
                Toast toast = Toast.makeText(context, text, duration); toast.show();
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 500);

            }
        });

        //volume control bar

        SeekBar volumeControl = findViewById(R.id.volumeControl);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void gMaps(View view){
        Intent gMapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com"));
        startActivity(gMapsIntent);

    }

    public void hospital(View view){
        Intent hospitalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?source=hp&ei=-485WuvaDcuMmQGClL7AAw&q=hospital+near+me&oq=hospital+near+me&gs_l=psy-ab.3..0l2j0i20i264k1j0l7.969.3122.0.3286.17.13.0.3.3.0.160.1552.3j10.13.0....0...1c.1.64.psy-ab..1.16.1588.0..35i39k1j0i131k1j0i67k1j0i20i263i264k1j0i20i263k1.0.OGThxUyOXXI"));
        startActivity((hospitalIntent));
    }

    public void emergency(View view){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:911"));
        startActivity(callIntent);
    }

}