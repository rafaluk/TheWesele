package com.example.rafalklat.thewesele;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by marekklat on 27.03.2017.
 */

public class MainFragment extends Fragment {
//TODO zamiana tekstow na stringi i angielskie
    Button details_button;
    Button contact_button;
    TextView days;
    TextView hours;
    TextView minutes;
    TextView seconds;

    final long WEDDING_TIME = 1502550000000L;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: PRZEBUDOWAĆ CAŁY WIDOK
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        days = (TextView) rootView.findViewById(R.id.months);
        hours = (TextView) rootView.findViewById(R.id.hours);
        minutes = (TextView) rootView.findViewById(R.id.minutes);
        seconds = (TextView) rootView.findViewById(R.id.seconds);

        new CountDownTimer(WEDDING_TIME - Calendar.getInstance().getTimeInMillis(), 1000) {
            public void onTick(long millisUntilFinished) {
                //TODO zamienic na miesiace, a nie dni
                days.setText("" + (millisUntilFinished / 1000 / 60 / 60 / 24));
                hours.setText("" + (millisUntilFinished / 1000 / 60 / 60) % 24);
                minutes.setText("" + (millisUntilFinished / 1000 / 60) % 60);
                seconds.setText("" + (millisUntilFinished / 1000) % 60);
            }

            public void onFinish() {
                //TODO tutaj lepiej obsluzyc
                seconds.setText("Zaczęło się! :)");
            }
        }.start();
        return rootView;
    }
}
