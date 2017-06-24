package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SnackBar extends AppCompatActivity {

    private final String title = "Activity: Snack-Bar";
    private Button btnSnackBar, btnCustomSnackBar, btnSnackClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        this.setTitle(title);
        setButtons();

        btnSnackClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void setButtons(){

        btnSnackBar = (Button)findViewById(R.id.btnSnackBar);
        btnCustomSnackBar = (Button)findViewById(R.id.btnCustomSnackBar);
        btnSnackClose = (Button)findViewById(R.id.btnSnackClose);
    }
}
