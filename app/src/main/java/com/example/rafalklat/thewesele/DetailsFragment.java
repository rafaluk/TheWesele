package com.example.rafalklat.thewesele;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DetailsFragment extends Fragment {

    Button churchMap;
    Button partyMap;
    Button gifts;

    //wspolrzedne kosciola Michala Archaniola
    String churchCoordinates = "Kościół Parafii św. Michała Archanioła w Płońsku";

    //wspolrzedne Perlowego Dworu
    String partyCoordinates = "Perłowy Dwór, Nowe Olszyny";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);

        final Uri churchCoordinatesUri = Uri.parse("http://maps.google.com/maps?daddr="+churchCoordinates);
        final Uri partyCoordinatesUri = Uri.parse("http://maps.google.com/maps?daddr="+partyCoordinates);

        churchMap = (Button) rootView.findViewById(R.id.churchMap);
        partyMap = (Button) rootView.findViewById(R.id.partyMap);
        gifts = (Button) rootView.findViewById(R.id.gifts);

        churchMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, churchCoordinatesUri);
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

        gifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment giftsDialog = new GiftsDialogFragment();
                giftsDialog.show(getFragmentManager(), "missiles");

            }
        });

        return rootView;

    }
}
