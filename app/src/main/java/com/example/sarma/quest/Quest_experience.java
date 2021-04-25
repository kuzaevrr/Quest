package com.example.sarma.quest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Quest_experience extends AppCompatActivity implements View.OnTouchListener {

    private ImageView barbell; //штанга
    private ImageView cargo; //груз
    private ImageView glassful; //стакан
    private int[] barbellArray = {0, R.drawable.start, R.drawable.b22, R.drawable.b23, R.drawable.b24, R.drawable.b25,
            R.drawable.aa, R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24, R.drawable.start2};
    public static int mX;
    public static int mY;
    public RelativeLayout.LayoutParams layoutParams;
    int q = 0;
    private DisplayMetrics displayMetrics;
    private int onePercentWidth;
    private int onePercentHeight;

    double dI;
    boolean keyOne = true;
    boolean keyTwo = true;

    int height;
    int width;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experience_new);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        {
            displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            onePercentWidth = displayMetrics.widthPixels / 100;
            onePercentHeight = displayMetrics.heightPixels / 100;
        }
        {
            barbell = findViewById(R.id.barbell);
            cargo = findViewById(R.id.cargo);
            glassful = findViewById(R.id.glassful);
        }
        layoutParams = new RelativeLayout.LayoutParams(onePercentWidth * 7, onePercentWidth * 7);
        layoutParams.leftMargin = onePercentWidth * 45;
        layoutParams.topMargin = displayMetrics.heightPixels - onePercentHeight * 35;
        cargo.setLayoutParams(layoutParams);
        cargo.setOnTouchListener(this);
//        ratio(displayMetrics.widthPixels, displayMetrics.heightPixels);
        dI = (double) displayMetrics.widthPixels / displayMetrics.heightPixels;
        Log.i("LogPercent", Double.toString(dI));
    }

    public boolean onTouch(final View view, MotionEvent event) {

        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                mX = X - lParams.leftMargin;
                mY = Y - lParams.topMargin;
                System.out.println("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                if (height + 150 > Y && width > X) {
                    layoutParams.leftMargin = X - mX;
                    layoutParams.topMargin = Y - mY;
                    System.out.println("ACTION_MOVE");
                }
                break;
        }

//        RelativeLayout.LayoutParams marginLayoutParams = (RelativeLayout.LayoutParams) barbell.getLayoutParams();
//        Log.i("marginXYL", marginLayoutParams.bottomMargin + "||" + marginLayoutParams.leftMargin + "||" + this.getResources().getDisplayMetrics().density);

//        int marginXL = (int) (onePercentWidth * 7.6 + barbell.getWidth() * 0.75);
//        int marginYL = (int) (onePercentHeight * 100 - dpToPx(this, 150) + dpToPx(this, 60));
        double pr1 = (int) (25 * resDI(dI));
        int marginXL = (int) (onePercentWidth * pr1); //33
        int marginYL = (int) (onePercentHeight * 100 / 2 + dpToPx(this, (int) (pr1 + 55))); //60
        System.out.println("Истина 1: x(" + marginXL + ") y(" + marginYL + ")\nПолучаем 1: x(" + X + ") y(" + Y + ")");

        if (marginXL <= X + 50 && marginXL >= X - 50 &&
                marginYL <= Y + 70 && marginYL >= Y - 70 &&
                (q == 0)) {
            cargo.setImageResource(barbellArray[0]);
            if (keyOne) {
                startCountdownTimer(3000, 11);
            }
            keyOne = false;
        }

//        int marginXLBarbell = (int) (onePercentWidth * 7.6 + barbell.getWidth() * 0.94);
//        int marginYLBarbell = (int) (onePercentHeight * 100 - dpToPx(this, 150) + dpToPx(this, 60));
        double pr2 = (int) (29 * resDI(dI));
        int marginXLBarbell = (int) (onePercentWidth * pr2);//37
        int marginYLBarbell = (int) (onePercentHeight * 100 / 2 + dpToPx(this, (int) (pr2 + 40)));//55
        System.out.println("Истина 2: x(" + marginXLBarbell + ") y(" + marginYLBarbell + ")\nПолучаем 2: x(" + X + ") y(" + Y + ")");

        if (marginXLBarbell <= X + 20 && marginXLBarbell >= X - 20 &&
                marginYLBarbell <= Y + 50 && marginYLBarbell >= Y - 50 &&
                q == 1) {
            glassful.setVisibility(View.INVISIBLE);
            if (keyTwo) {
                startCountdownTimer(2000, 5);
            }
            keyTwo = false;
        }


        view.setLayoutParams(layoutParams);
        return true;
    }

    public void viewThread(int time, int numb) {

        if (time > 0 && time <= 500) {
            barbell.setImageResource(barbellArray[numb]);
        } else if (time > 501 && time <= 1000) {
            barbell.setImageResource(barbellArray[numb - 1]);
        } else if (time > 1001 && time <= 1500) {
            barbell.setImageResource(barbellArray[numb - 2]);
        } else if (time > 1501 && time <= 2000) {
            barbell.setImageResource(barbellArray[numb - 3]);
        } else if (time > 2001 && time <= 2500) {
            barbell.setImageResource(barbellArray[numb - 4]);
        } else if (time > 2501 && time <= 3000) {
            barbell.setImageResource(barbellArray[numb - 5]);
        }
    }


    private int pxToDp(Context context, int px) {
        return (int) (px / context.getResources().getDisplayMetrics().density);
    }

    private int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private int percentWidth(int px) {
        return px / (displayMetrics.widthPixels / 100);
    }

    private int percentHeight(int px) {
        return px / (displayMetrics.heightPixels / 100);
    }

    private double pxToPercentWidth(double px) {
        return px * (int) (displayMetrics.widthPixels / 100);
    }

    private double pxToPercentHeight(double px) {
        return px * (int) (displayMetrics.heightPixels / 100);
    }

    private int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    private void ratio(int a, int b) {
        final int gcd = gcd(a, b);
        if (a > b) {
            showAnswer(a / gcd, b / gcd);
        } else {
            showAnswer(b / gcd, a / gcd);
        }
    }

    private void showAnswer(int a, int b) {
        System.out.println(a + " " + b);
    }

    public boolean Collision(ImageView net, ImageView ball) {
        Rect BallRect = new Rect();
        ball.getHitRect(BallRect);
        Rect NetRect = new Rect();
        net.getHitRect(NetRect);
        return BallRect.intersect(NetRect);
    }

    public void startCountdownTimer(int time, final int numb) {
        CountDownTimer count = new CountDownTimer(time, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                viewThread((int) millisUntilFinished, numb);
            }

            @Override
            public void onFinish() {
                if (q == 0 && numb == 11) {
                    q = 1;
                    RelativeLayout.LayoutParams real = (RelativeLayout.LayoutParams) glassful.getLayoutParams();
                    layoutParams.rightMargin = width - real.leftMargin + glassful.getWidth();
                    layoutParams.bottomMargin = real.bottomMargin;
                    glassful.setLayoutParams(layoutParams);

                    glassful.setVisibility(View.VISIBLE);
                } else if (q == 1 && numb == 5) {

                    q = 2;
                    Intent intent = new Intent(Quest_experience.this, Finish.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        count.start();
    }

    public double resDI(double dI) {
        if (dI <= 2.2 && dI > 2.0) {
            return 1.4;
        } else if (dI <= 2.0 && dI > 1.8) {
            return 1.3;
        } else if (dI <= 1.8 && dI > 1.6) {
            return 1.2;
        } else if (dI <= 1.6 && dI > 1.4) {
            return 1.14;
        } else if (dI <= 1.4 && dI > 1.2) {
            return 1.0;
        }
        return 0;
    }
}


