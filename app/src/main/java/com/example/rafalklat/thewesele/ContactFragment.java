package com.example.rafalklat.thewesele;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by marekklat on 27.03.2017.
 */

public class ContactFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        ImageView asiniTel = (ImageView) rootView.findViewById(R.id.asiniTel);
        ImageView rafiniTel = (ImageView) rootView.findViewById(R.id.rafiniTel);
        ImageView asiniMail = (ImageView) rootView.findViewById(R.id.asiniMail);
        ImageView rafiniMail = (ImageView) rootView.findViewById(R.id.rafiniMail);

        //TODO telefony też jakos publicznie pobierac z main activity
        asiniTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+48781622879"));
                startActivity(intent);
            }
        });
        rafiniTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+48664495049"));
                startActivity(intent);
            }
        });
        //TODO datę jakoś publicznie pobierac z main activity
        asiniMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:stolpa.joanna@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Weselisko 12.08.2017 r.");
                startActivity(Intent.createChooser(emailIntent, "Wyślij maila z:"));
            }
        });
        rafiniMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rafal.klat@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Weselisko 12.08.2017 r.");
                startActivity(Intent.createChooser(emailIntent, "Wyślij maila z:"));
            }
        });

        return rootView;
    }
}
