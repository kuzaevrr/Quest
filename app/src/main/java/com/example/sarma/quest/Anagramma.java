package com.example.sarma.quest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Anagramma extends AppCompatActivity {

    public EditText editText1;
    public EditText editText2;
    public EditText editText3;
    private Button Button;
    private TextView Text;
    private ImageView Image1;
    private ImageView Image2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anagramma);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        editText1 = (EditText) findViewById(R.id.editText3);
        Button = (Button) findViewById(R.id.button);
        editText2 = (EditText) findViewById(R.id.editText4);
        editText3 = (EditText) findViewById(R.id.editText5);
        Text = (TextView) findViewById(R.id.textView13);
        Image1 = (ImageView) findViewById(R.id.imageView2);
        Image2 = (ImageView) findViewById(R.id.imageView3);
    }

    public void Test(View v) {
        if (editText1.getText().toString().equals("сила")
                & editText2.getText().toString().equals("плотность")
                & editText3.getText().toString().equals("корону")) {

            Text.setVisibility(View.GONE);
            Button.setVisibility(View.GONE);
            editText1.setVisibility(View.GONE);
            editText2.setVisibility(View.GONE);
            editText3.setVisibility(View.GONE);
            Image1.setVisibility(View.GONE);
            Image2.setVisibility(View.GONE);
            Intent intent = new Intent(this, Сouple.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
        }
    }
}
