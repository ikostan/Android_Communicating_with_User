package com.example.training.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Created by superadmin on 30-Jun-17.
 */

public class SimpleDialogFragment extends DialogFragment{

    private final String title = "SimpleDialogFragment: sample";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Blah blah title");
        builder.setMessage("Question...?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.i("PositiveButton", "Positive button clicked");
                Toast toast = Toast.makeText(getActivity(), "Positive button clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.i("NegativeButton", "Negative button clicked");
                Toast toast = Toast.makeText(getActivity(), "Negative button clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
            }
        });

        builder.setNeutralButton("No idea", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.i("NeutralButton", "Neutral button clicked");
                Toast toast = Toast.makeText(getActivity(), "Neutral button clicked", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
            }
        });

        return builder.create();
    }


    @Override
    public void onCancel(DialogInterface dlg){

        super.onCancel(dlg);
        Log.i("onCancel", "Dialog cancelled");
        Toast toast = Toast.makeText(getActivity(), "Dialog cancelled", Toast.LENGTH_SHORT);
    }

    //public void show(FragmentManager supportFragmentManager, String s) {}
}
