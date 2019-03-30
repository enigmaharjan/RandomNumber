package com.example.randomnumber;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btFirst, btSec;
    private TextView tvResult, tvcorrect, tvincorrect;
    private int correct, incorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        btSec = findViewById(R.id.btnSec);
        btFirst = findViewById(R.id.btnFst);
//        tvcorrect = findViewById(R.id.tvCorrect);
//        tvincorrect = findViewById(R.id.tvIncorrect);


        tvResult.setText("0");

        random();

        btFirst.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(btFirst.getText().toString()) > Integer.parseInt(btSec.getText().toString())) {
                    int set = Integer.parseInt(tvResult.getText().toString());
                    set++;
                    tvResult.setText(Integer.toString(set));            // Setting value to view. Must always be only set from integer only, since it needs to be retrieved.
//                    btFirst.setBackgroundColor(Color.green(1));

                    ///
                    correctButtonChange(btFirst);

                    correct();
                    random();

                    // The following function checks whether the given criteria matches, if it does then the codes executes.
                    if (Integer.parseInt(tvResult.getText().toString()) == 5) {
                        int cor = correct() - 1;                        // -1 is done since upon calling correct() method it adds another number to the result.
                        String a = Integer.toString(cor);

                        int in = incorrect() - 1;                        // -1 is done since upon calling correct() method it adds another number to the result.
                        String b = Integer.toString(in);

                        //Transfer Message to game_over.xml through intent.
                        Intent intent = new Intent(getApplicationContext(), GameOver.class);
                        intent.putExtra("message", a);
                        intent.putExtra("message2", b);

                        startActivity(intent);
                        finish();                                       //closes this activity from memory
                    }
                } else {
                    int set = Integer.parseInt(tvResult.getText().toString());
                    set--;
                    incorrectButtonChange(btFirst);
                    tvResult.setText(Integer.toString(set));
                    incorrect();
                    random();

                }
            }
        });

        btSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(btFirst.getText().toString()) < Integer.parseInt(btSec.getText().toString())) {
                    int set = Integer.parseInt(tvResult.getText().toString());
                    set++;
                    tvResult.setText(Integer.toString(set));            // Setting value to view. Must always be only set from integer only, since it needs to be retrieved.

                    ///
                    correctButtonChange(btSec);

                    correct();
                    random();

                    // The following function checks whether the given criteria matches, if it does then the codes executes.
                    if (Integer.parseInt(tvResult.getText().toString()) == 5) {

                        int cor = correct() - 1;                        // -1 is done since upon calling correct() method it adds another number to the result.
                        String a = Integer.toString(cor);

                        int in = incorrect() - 1;                        // -1 is done since upon calling correct() method it adds another number to the result.
                        String b = Integer.toString(in);

                        //Transfer Message
                        Intent intent = new Intent(getApplicationContext(), GameOver.class);
                        intent.putExtra("message", a);
                        intent.putExtra("message2", b);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    int set = Integer.parseInt(tvResult.getText().toString());
                    set--;
                    incorrectButtonChange(btSec);
                    tvResult.setText(Integer.toString(set));
                    incorrect();
                    random();
                }
            }
        });


    }

    public void random() {

        int random2 = (int) (Math.random() * 100 + 1);
        btSec.setText(Integer.toString(random2));

        int random = (int) (Math.random() * 100 + 1);
        btFirst.setText(Integer.toString(random));
    }

    public int correct() {
        correct += 1;
        return correct;

    }

    public int incorrect() {
        incorrect += 1;
        return incorrect;
    }

    public void correctButtonChange(Button bt){
        bt.setBackgroundColor(Color.GREEN);
        bt.animate().setDuration(300).withEndAction(new Runnable() {
            @Override
            public void run() {
                // set color back to normal
                btFirst.setBackgroundColor(Color.GRAY);
                btSec.setBackgroundColor(Color.GRAY);
            }
        }).start();
    }

    public void incorrectButtonChange(Button bt){
        bt.setBackgroundColor(Color.RED);
        bt.animate().setDuration(200).withEndAction(new Runnable() {
            @Override
            public void run() {
                // set color back to normal
                btFirst.setBackgroundColor(Color.GRAY);
                btSec.setBackgroundColor(Color.GRAY);
            }
        }).start();
    }
}
