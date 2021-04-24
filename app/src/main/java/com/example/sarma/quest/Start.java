package com.example.sarma.quest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends AppCompatActivity {
    private android.widget.Button Button;
    private TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button = (Button) findViewById(R.id.button18);
        Text = (TextView) findViewById(R.id.textView18);
    }

    public void start(View v) {
        Button.setVisibility(View.GONE);
        Text.setVisibility(View.GONE);
        Intent intent = new Intent(this, Anagramma.class);
        startActivity(intent);
    }
}

