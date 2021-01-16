package com.example.sarma.quest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Сouple extends AppCompatActivity {
    private TextView Text1;
    private TextView Text2;
    private TextView Text3;
    boolean[] state;
    boolean[] exist;
    int relationship[][] = {
            {0}, {0}, {0},
            {10, 0}, {0}, {9, 4},
            {0}, {6, 2}, {1, 11},
            {0}, {0}, {0},
    };
    int k=0;
    int arId[];
    int countActive;
    ImageView imageView;
    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.couple);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        state = new boolean[12];
        exist = new boolean[12];
        for (int j = 0; j < state.length; j++) {
            state[j] = false;
            exist[j] = true;
        }
        arId = new int[12];

        arId[0] = R.id.button0;
        arId[1] = R.id.button1;
        arId[2] = R.id.button2;
        arId[3] = R.id.button3;
        arId[4] = R.id.button4;
        arId[5] = R.id.button5;
        arId[6] = R.id.button6;
        arId[7] = R.id.button7;
        arId[8] = R.id.button8;
        arId[9] = R.id.button9;
        arId[10] = R.id.button10;
        arId[11] = R.id.button11;

        Text1 = (TextView) findViewById(R.id.textView3);
        Text2 = (TextView) findViewById(R.id.textView4);
        Text3 = (TextView) findViewById(R.id.textView5);

    }


    public void buttonClicked(View v) {
        int id = v.getId(); // layout id

        int rid = -1; // id в виде 0-11
        for (int i = 0; i < arId.length; i++) {
            if (id == arId[i]) {
                rid = i;
                break;
            }
        }

        countActive = 0;
        for (int j = 0; j < state.length; j++) {
            if (state[j] && j != rid) {
                countActive++;
            }
        }

        if (countActive == 2) {
            int[] relate = relationship[rid];
            boolean result = true;
            for (int i = 0; i < relate.length; i++) {
                if (!state[relate[i]]) {
                    result = false;
                }
            }

            if (result) { // правильная комбинация
                findViewById(arId[relate[0]]).setVisibility(View.INVISIBLE);
                findViewById(arId[relate[1]]).setVisibility(View.INVISIBLE);
                findViewById(id).setVisibility(View.INVISIBLE);
                exist[relate[0]] = false;
                exist[relate[1]] = false;
                exist[rid] = false;
                k++;
                Toast.makeText(getApplicationContext(), "Формула успешно собрана", Toast.LENGTH_LONG).show();
                for (int j = 0; j < state.length; j++) {
                    state[j] = false;
                }
            } else {
                for (int i = 0; i < exist.length; i++) {
                    state[i] = false;
                    if (exist[i]) {
                        findViewById(arId[i]).setBackgroundColor(Color.WHITE);
                    }
                }
                Toast.makeText(getApplicationContext(), "Попробуй еще раз", Toast.LENGTH_LONG).show();
            }
        } else {
            state[rid] = true;
            findViewById(id).setBackgroundColor(Color.GRAY);
        }
        boolean flag = true;
        String s = "";
        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                flag = false;
            }
        }
        if (k==4) {
            Text1.setVisibility(View.GONE);
            Text2.setVisibility(View.GONE);
            Text3.setVisibility(View.GONE);
            Intent intent = new Intent(this, Task.class);
            startActivity(intent);
        }
    }


}








