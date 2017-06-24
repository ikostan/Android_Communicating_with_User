package com.example.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnLaunchToast, btnLaunchSnackBar, btnLaunchDialog, btnNotification, btnClose;
    //Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtons();

        btnLaunchToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(MainActivity.this, Activity_toast.class);
                startActivity(newIntent);
            }
        });

        btnLaunchSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLaunchDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Close app
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setButtons(){

        btnLaunchToast = (Button) findViewById(R.id.btnLaunchToast);
        btnLaunchSnackBar = (Button) findViewById(R.id.btnLaunchSnackBar);
        btnLaunchDialog = (Button) findViewById(R.id.btnLaunchDialog);
        btnNotification = (Button) findViewById(R.id.btnNotification);
        btnClose = (Button) findViewById(R.id.btnClose);
    }

}
