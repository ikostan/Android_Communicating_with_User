package com.example.training;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SnackBar extends AppCompatActivity implements View.OnClickListener{

    private Button buttonClose, buttonSnackBar, buttonActionSnackBar;
    private Snackbar snackBar, actionSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle("SnackBar Demo");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setButtons(); //Create buttons

        //Close button
        buttonClose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close the view
                finish();
            }
        });

        //Show regular SnackBar
        buttonSnackBar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackBar();
            }
        });

        //Show Action-SnackBar
        buttonActionSnackBar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showActionSnackBar();
            }
        });

    }

    //Create buttons
    private void setButtons(){

        buttonClose = (Button)findViewById(R.id.buttonClose);
        buttonSnackBar = (Button)findViewById(R.id.buttonSnackBar);
        buttonActionSnackBar = (Button)findViewById(R.id.buttonActionSnackBar);
    }

    //Regular SnackBar
    private void showSnackBar(){

        Log.d("showSnackBar: ", "Started");
        snackBar = Snackbar.make(findViewById(R.id.snackCoordinatorLayout), "Regular SnackBar", Snackbar.LENGTH_LONG);
        snackBar.show();
        Log.d("showSnackBar: ", "Finished");
    }

    //Action SnackBar
    private void showActionSnackBar(){

        Log.d("showActionSnackBar: ", "Started");
        actionSnackBar = Snackbar.make(findViewById(R.id.snackCoordinatorLayout), "Action SnackBar", Snackbar.LENGTH_LONG);
        actionSnackBar.setAction("Tap here",new OnClickListener(){
            @Override
            public void onClick(View view){

                Toast myToast = Toast.makeText(SnackBar.this, "This is your action", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.CENTER, 0,0);
                myToast.show();
            }
        });

        actionSnackBar.setActionTextColor(Color.YELLOW);
        actionSnackBar.show();
        Log.d("showActionSnackBar: ", "Finished");
    }

    @Override
    public void onClick(View v) {

    }

    //END
}
