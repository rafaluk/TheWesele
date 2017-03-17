package com.example.rafalklat.thewesele;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

//    float WEDDING_TIME = 1512748800000;
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

        details_button = (Button) findViewById(R.id.details_button);
        contact_button = (Button) findViewById(R.id.contact_button);

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
        
        new CountDownTimer(1502550000000L-Calendar.getInstance().getTimeInMillis(), 1000) {
            public void onTick(long millisUntilFinished) {
                days.setText(""+(millisUntilFinished/1000/60/60/24));
                hours.setText(""+(millisUntilFinished/1000/60/60)%24);
                minutes.setText(""+(millisUntilFinished/1000/60)%60);
                seconds.setText(""+(millisUntilFinished/1000)%60);
            }

            public void onFinish() {
                seconds.setText("Zaczęło się! :)");
            }
        }.start();
    }
}
