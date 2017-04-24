package com.example.rafalklat.thewesele;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GiftsDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Kochani Goście,\nuprzejmie Was prosimy o niekupowanie nam kwiatków. Dwa dni po ślubie wylatujemy na podróż " +
                "poślubną, więc i tak się nimi nie nacieszymy. Zamiast tego będziemy wdzięczni za butelkę dobrego wina, tak aby " +
                "rozweselić te najbliższe 80 lat, które ze sobą spędzimy. :)")
                .setNeutralButton("ZAMKNIJ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}