package com.example.rafalklat.thewesele;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    TextView months;
    TextView days;
    TextView hours;
    TextView minutes;
    TextView seconds;

    final long WEDDING_TIME = 1502550000000L;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Calendar weddingTime = Calendar.getInstance();
        weddingTime.set(2017, 7, 12, 18, 0, 0); //miesiac -1, godzina +1

        months = (TextView) rootView.findViewById(R.id.months);
        days = (TextView) rootView.findViewById(R.id.days);
        hours = (TextView) rootView.findViewById(R.id.hours);
        minutes = (TextView) rootView.findViewById(R.id.minutes);
        seconds = (TextView) rootView.findViewById(R.id.seconds);

        new CountDownTimer(weddingTime.getTimeInMillis() - Calendar.getInstance().getTimeInMillis(), 1000) {
            public void onTick(long millisUntilFinished) {
                //TODO zamienic na miesiace, a nie dni

                Calendar roznica = Calendar.getInstance();
                roznica.setTimeInMillis(millisUntilFinished);

//                Log.d("left: ",Integer.toString(miechy)+"mc, "+Integer.toString(dniechy)+"d, "+Integer.toString(godzinki)+"h.");
//TODO sprawdzic, ktory sposob jest wydajniejszy
                months.setText(Integer.toString(roznica.get(Calendar.MONTH)));
                days.setText(Integer.toString(roznica.get(Calendar.DAY_OF_MONTH)));
                hours.setText(Integer.toString(roznica.get(Calendar.HOUR_OF_DAY)));
                minutes.setText(Integer.toString(roznica.get(Calendar.MINUTE)));
                seconds.setText(Integer.toString(roznica.get(Calendar.SECOND)));
//                days.setText("" + (millisUntilFinished / 1000 / 60 / 60 / 24));
//                hours.setText("" + (millisUntilFinished / 1000 / 60 / 60) % 24);
//                minutes.setText("" + (millisUntilFinished / 1000 / 60) % 60);
//                seconds.setText("" + (millisUntilFinished / 1000) % 60);
            }

            public void onFinish() {
                //TODO tutaj lepiej obsluzyc
                seconds.setText("Zaczęło się! :)");
            }
        }.start();
        return rootView;
    }
}
