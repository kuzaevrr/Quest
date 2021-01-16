package com.example.sarma.quest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    private VideoView videoView;
    private Button Button1;
    private Button Button2;
    private int position = 0;
    public EditText editText;
    private TextView Text1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initUI();

    }
    private void initUI() {
        editText = (EditText)findViewById(R.id.editText);
        Text1 = (TextView) findViewById(R.id.textView);
        Button1 = (Button) findViewById(R.id.button12);
        Button2 = (Button) findViewById(R.id.button13);
        videoView = (VideoView) findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.garri);
        videoview.setVideoURI(uri);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.seekTo(position);
                if (position == 0)
                    videoView.start();
                }

        });
    }



    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("position");
        videoView.seekTo(position);
    }
    public void Test(View v) {
        if (editText.getText().toString().equals("810")) {
            Text1.setVisibility(View.GONE);
            Button1.setVisibility(View.GONE);
            Button2.setVisibility(View.GONE);
            videoView.setVisibility(View.GONE);
            editText.setVisibility(View.GONE);
            Intent intent = new Intent(this, Quest_experience.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
        }
    }
    public void Help(View v) {
        Toast.makeText(getApplicationContext(), "Сила тяжести должна быть равна силе Архимеда", Toast.LENGTH_LONG).show();
    }
    public void clear(View v) {
        editText.setText("");
    }
    }

