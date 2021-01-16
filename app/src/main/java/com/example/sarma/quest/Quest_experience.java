package com.example.sarma.quest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Quest_experience extends AppCompatActivity implements View.OnTouchListener {

    private android.widget.ImageView ImageView;
    private ImageView mImageView;
    private int[] ImageArray = {0, R.drawable.start, R.drawable.start21, R.drawable.start2, R.drawable.b25, R.drawable.aa, R.drawable.t5};
    private int[] mImageArray = {0, R.drawable.gruz, R.drawable.lapka, R.drawable.stakan};
    private int mX;
    private int mY;
    public RelativeLayout.LayoutParams layoutParams;
    private AnimationDrawable mAnimationDrawable;
    int q = 0;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experience);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mImageView = findViewById(R.id.imageView);
        ImageView = findViewById(R.id.ImageView1);
        layoutParams = new RelativeLayout.LayoutParams(105, 145);
        layoutParams.leftMargin = 1050;
        layoutParams.topMargin = 750;
        mImageView.setLayoutParams(layoutParams);
        mImageView.setOnTouchListener(this);
        ImageView.setImageResource(ImageArray[1]);
        mImageView.setImageResource(mImageArray[1]);

    }

    public boolean onTouch(final View view, MotionEvent event) {

        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        if (Y >= 5) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    if (q != 1) mX = X - lParams.leftMargin;
                    mY = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    if (q != 1) layoutParams.leftMargin = X - mX;
                    layoutParams.topMargin = Y - mY;
                    break;
            }
        }
        if ((((layoutParams.leftMargin - 430) * (layoutParams.leftMargin - 430)) + ((layoutParams.topMargin - 470) * (layoutParams.topMargin - 470)) <= 50) && (q == 0)) {
            q = 1;
            ImageView.setImageResource(ImageArray[5]);
            mImageView.setImageResource(mImageArray[0]);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    layoutParams = new RelativeLayout.LayoutParams(308, 680);
                    ImageView.setImageResource(ImageArray[2]);
                    mImageView.setImageResource(mImageArray[2]);
                    layoutParams.leftMargin = 225;
                    mImageView.setLayoutParams(layoutParams);
                }
            }, 100);
        }


        if ((((layoutParams.topMargin - 20) * (layoutParams.topMargin - 20)) <= 50) && (q == 1)) {
            ImageView.setImageResource(ImageArray[0]);
            mImageView.setImageResource(mImageArray[0]);
            ImageView.setBackgroundResource(R.drawable.animation1);
            mAnimationDrawable = (AnimationDrawable) ImageView.getBackground();
            mAnimationDrawable.start();
            q = 2;

        }

        if ((q == 2) && (i == 0)) {
            i = 1;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    mImageView.setBackgroundResource(0);
                    layoutParams = new RelativeLayout.LayoutParams(147, 118);
                    ImageView.setImageResource(ImageArray[3]);
                    mImageView.setImageResource(mImageArray[3]);
                    layoutParams.leftMargin = 583;
                    layoutParams.topMargin = 792;
                    mImageView.setLayoutParams(layoutParams);
                }
            }, 1000);

        }


        if ((((layoutParams.leftMargin - 430) * (layoutParams.leftMargin - 430)) + ((layoutParams.topMargin - 500) * (layoutParams.topMargin - 500)) <= 50) && (q == 2) && (i == 1)) {
            q = 3;
            ImageView.setImageResource(ImageArray[0]);
            mImageView.setImageResource(mImageArray[0]);
            ImageView.setBackgroundResource(R.drawable.animation2);
            mAnimationDrawable = (AnimationDrawable) ImageView.getBackground();
            mAnimationDrawable.start();

        }
        if (q == 3) {
            Intent intent = new Intent(this, Finish.class);
            startActivity(intent);
        }
        view.setLayoutParams(layoutParams);

        return true;
    }
}


