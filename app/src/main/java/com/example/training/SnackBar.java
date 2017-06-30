package com.example.training;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SnackBar extends AppCompatActivity implements View.OnClickListener{

    private final String title = "Activity: Snack-Bar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle(title);

        findViewById(R.id.btnSnackBar).setOnClickListener(this);
        findViewById(R.id.btnCustomSnackBar).setOnClickListener(this);
        findViewById(R.id.btnSnackClose).setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){

        switch(v.getId()){

            case R.id.btnSnackBar:
                showSnackBar();
                break;
            case R.id.btnCustomSnackBar:
                showActionSnackBar();
                break;
            case R.id.btnSnackClose:
                finish();
        }
    }


    private void showSnackBar(){

        Snackbar snack = Snackbar.make(findViewById(R.id.myConstraintLayout2),
                "This is regular snackbar",
                Snackbar.LENGTH_LONG);
        snack.show();
    }

    private void showActionSnackBar(){

        Snackbar snackAction = Snackbar.make(findViewById(R.id.myConstraintLayout2),
                "This is action snackbar",
                Snackbar.LENGTH_LONG);
        snackAction.setAction("My Action", new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Toast.makeText(SnackBar.this, "SnackBar action tap", Toast.LENGTH_SHORT).show();
            }
        });

        snackAction.setActionTextColor(Color.RED);
        snackAction.show();
    }

}
