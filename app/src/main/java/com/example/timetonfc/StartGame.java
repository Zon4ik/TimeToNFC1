package com.example.timetonfc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Locale;


public class StartGame extends AppCompatActivity {
    int team_1 = 0;
    int team_2 = 0;
    TextView num_1;
    TextView num_2;

    TextToSpeech speech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        this.num_1 = (TextView) findViewById(R.id.num_1);
        this.num_2 = (TextView) findViewById(R.id.num_2);
        String str_num_1 = Integer.toString(team_1);
        String str_num_2 = Integer.toString(team_2);
        speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    Locale locale = new Locale("ru");
                    speech.setLanguage(locale);
                }
            }
        });

        num_1.setText(str_num_1);
        num_2.setText(str_num_2);

    }
    @SuppressLint("DefaultLocale")
    public void test1(View view) {
        team_1++;
        String str_num_1 = Integer.toString(team_1);
        String str_num_2 = Integer.toString(team_2);

        num_1.setText(str_num_1);
        if(team_1 == 3 & team_2 != 2 & team_2 != 3) {
            team_1 = 0;
            team_2 = 0;

            str_num_1 = Integer.toString(team_1);
            str_num_2 = Integer.toString(team_2);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Команда 1 победила", Toast.LENGTH_SHORT);
            toast.show();

            num_1.setText(str_num_1);
            num_2.setText(str_num_2);
        }

        if(team_1 >=3 & team_1 - team_2 == 2){
            team_1 = 0;
            team_2 = 0;
            str_num_1 = Integer.toString(team_1);
            str_num_2 = Integer.toString(team_2);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Команда 1 победила", Toast.LENGTH_SHORT);
            toast.show();
            num_1.setText(str_num_1);
            num_2.setText(str_num_2);

        }
        if (!(team_1 == 0 & team_2 == 0)){
            speech.speak(MessageFormat.format(" {0}, {1}", str_num_1, str_num_2), TextToSpeech.QUEUE_FLUSH, null, "id1");
        }

    }

    public void test2(View view) {
        team_2++;
        String str_num_2 = Integer.toString(team_2);
        String str_num_1 = Integer.toString(team_1);

        num_2.setText(str_num_2);
        if (team_2 == 3 & team_1 != 2 & team_1 != 3) {
            team_1 = 0;
            team_2 = 0;
            str_num_1 = Integer.toString(team_1);
            str_num_2 = Integer.toString(team_2);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Команда 2 победила", Toast.LENGTH_SHORT);
            toast.show();
            num_1.setText(str_num_1);
            num_2.setText(str_num_2);
        }
        if(team_2 >= 3 & team_2 - team_1 == 2) {
            team_1 = 0;
            team_2 = 0;
            str_num_1 = Integer.toString(team_1);
            str_num_2 = Integer.toString(team_2);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Команда 2 победила", Toast.LENGTH_SHORT);
            toast.show();
            num_1.setText(str_num_1);
            num_2.setText(str_num_2);
        }
        if (!(team_1 == 0 & team_2 == 0)){
            speech.speak(MessageFormat.format(" {1}, {0}", str_num_1, str_num_2), TextToSpeech.QUEUE_FLUSH, null, "id1");
        }
    }

}














