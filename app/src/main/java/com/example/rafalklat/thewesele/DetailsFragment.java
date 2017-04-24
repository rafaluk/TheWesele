package com.example.rafalklat.thewesele;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DetailsFragment extends Fragment {

    Button churchMap;
    Button partyMap;

    //wspolrzedne kosciola Michala Archaniola
    String churchCoordinates = "52.622165,20.374147";

    //wspolrzedne Perlowego Dworu
    String partyCoordinates = "52.531365,20.453259";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        return rootView;

        final Uri churchCoordinatesUri = Uri.parse("google.streetview:cbll="+churchCoordinates);
        final Uri partyCoordinatesUri = Uri.parse("google.streetview:cbll="+partyCoordinates);

        churchMap = (Button) rootView.findViewById(R.id.churchMap);
        partyMap = (Button) rootView.findViewById(R.id.partyMap);

        churchMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, churchCoordinatesUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        partyMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, partyCoordinatesUri)
                        .setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
