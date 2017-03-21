package com.example.rafalklat.thewesele;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContactActivity extends AppCompatActivity {
//TODO ustawic prosto twarze na XMLu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        Button back = (Button) findViewById(R.id.back);
        ImageView asiniTel = (ImageView) findViewById(R.id.asiniTel);
        ImageView rafiniTel = (ImageView) findViewById(R.id.rafiniTel);
        ImageView asiniMail = (ImageView) findViewById(R.id.asiniMail);
        ImageView rafiniMail = (ImageView) findViewById(R.id.rafiniMail);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        asiniMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:stolpa.joanna@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Weselisko 12.08.2017 r.");
                startActivity(Intent.createChooser(emailIntent, "Z której aplikacji chcesz wysłać maila?"));
            }
        });
        rafiniMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rafal.klat@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Weselisko 12.08.2017 r.");
                startActivity(Intent.createChooser(emailIntent, "Z której aplikacji chcesz wysłać maila?"));
            }
        });
    }
}
