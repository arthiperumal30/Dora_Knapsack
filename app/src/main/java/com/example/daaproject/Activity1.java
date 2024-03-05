package com.example.daaproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Activity1 extends AppCompatActivity {

    Button maxProBtn, minWeiBtn;
    TextView txt;
    Button button1;
    static String choice;
    static int wlimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        txt = findViewById(R.id.text2);
        button1 = findViewById(R.id.btn1);
        maxProBtn = findViewById(R.id.maxProBtn);
        minWeiBtn = findViewById(R.id.minWeiBtn);

        button1.setOnClickListener(view -> {

            Random random = new Random();
            wlimit = random.nextInt(100);
            txt.setText(Integer.toString(wlimit));
        });

        maxProBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Activity1.this,objectSelection.class);
            choice = "maxPro";
            startActivity(intent);
        });

        minWeiBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Activity1.this,objectSelection.class);
            choice = "minWei";
            startActivity(intent);
        });
    }


}
