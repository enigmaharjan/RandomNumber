package com.example.randomnumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver extends AppCompatActivity {
    private Button btReset;
    private TextView  tv2Cor, tv2Inc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_over);


        tv2Cor = findViewById(R.id.tv2Correct);
        tv2Inc= findViewById(R.id.tv2Incorrect);
        btReset = findViewById(R.id.btnReset);


        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        String str2 = intent.getStringExtra("message2");
        tv2Cor.setText("Correct: "+str);
        tv2Inc.setText("Incorrect: "+str2);

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it1);
                finish();
            }
        });


    }
}