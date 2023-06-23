package com.example.timetonfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button StartGame;
    Button writeNfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.StartGame = findViewById(R.id.button2);
        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartGame.class);
                MainActivity.this.startActivity(intent);
            }
        });
        this.writeNfc = findViewById(R.id.button);
        writeNfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WriteFnc.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }




}