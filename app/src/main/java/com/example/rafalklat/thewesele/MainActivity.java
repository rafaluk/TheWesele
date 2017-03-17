package com.example.rafalklat.thewesele;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    long WEDDING_TIME = 1502557200; //co to za typ? double? float?
    Button details_button;
    Button contact_button;
    TextView days;
    TextView hours;
    TextView minutes;
    TextView seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        days = (TextView) findViewById(R.id.days);
        hours = (TextView) findViewById(R.id.hours);
        minutes = (TextView) findViewById(R.id.minutes);
        seconds = (TextView) findViewById(R.id.seconds);


        details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO przekierowanie do aktywnosci szczegoly
            }
        });

        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO przekierowanie do aktywnosci kontakt
            }

        });

       // Calendar.getInstance().getTimeInMillis(); - to chyba zwróci czas

        new CountDownTimer(30000, 1000) {
            //TODO zamiast 30000 wstawic roznice: slub-dzis. slub na gorze.
            public void onTick(long millisUntilFinished) {
                seconds.setText(""+(millisUntilFinished/1000)%60);
            }

            public void onFinish() {
                seconds.setText("Zaczęło się! :)");
            }
        }.start();
    }


//    public void countTime() {
       // long msDiff = Calendar.getInstance().getTimeInMillis();
//        long daysDiff = TimeUnit.MILLISECONDS.toDays(msDiff);
//    }




}
