package com.example.sarma.quest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Task extends AppCompatActivity {

    private Button Button1;
    public EditText editText;
    private TextView Text1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        editText = (EditText)findViewById(R.id.editText2);
        Text1 = (TextView) findViewById(R.id.textView12);
        Button1 = (Button) findViewById(R.id.button);
    }
    public void Help(View v) {
        Toast.makeText(getApplicationContext(), "Сила тяжести должна быть равна силе Архимеда", Toast.LENGTH_LONG).show();
    }
    public void Test(View v) {
        if (editText.getText().toString().equals("721")) {
            Text1.setVisibility(View.GONE);
            Button1.setVisibility(View.GONE);
            editText.setVisibility(View.GONE);
            Intent intent = new Intent(this, Video.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
        }
    }
    public void clear(View v) {
        editText.setText("");
    }
}