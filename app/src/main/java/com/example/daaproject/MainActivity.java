package com.example.daaproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);

        button.setOnClickListener(view -> openActivity1());

    }
    public void openActivity1(){
        Intent intent = new Intent(this,Activity1.class);
        startActivity(intent);
    }


}