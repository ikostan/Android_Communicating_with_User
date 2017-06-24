package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_toast extends AppCompatActivity {

    private final String title = "Activity: TOAST";
    private Button btnToastClose, btnShowToast, btnShowCustomToast;
    private RadioGroup radioDuration, radioPosition;
    private int duration;
    private int duartion;
    private String text;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        this.setTitle(title);
        setButtons();
        radioDuration = (RadioGroup ) findViewById(R.id.radioDuration);
        radioPosition = (RadioGroup ) findViewById(R.id.radioPosition);


        btnToastClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = "This is regular toast";

                if(radioDuration.getCheckedRadioButtonId() == R.id.radioShort){

                    duartion = Toast.LENGTH_SHORT;
                    text += ": SHORT";
                }
                else if(radioDuration.getCheckedRadioButtonId() == R.id.radioLong){

                    duartion = Toast.LENGTH_LONG;
                    text += ": LONG";
                }
                else{
                    Toast.makeText(Activity_toast.this, "Please select TOAST DURATION first", Toast.LENGTH_SHORT).show();
                    return;
                }

                toast = Toast.makeText(getApplicationContext(), text, duration);

                if(radioPosition.getCheckedRadioButtonId() == R.id.radioCenter){

                    toast.setGravity(Gravity.CENTER, 0,0);
                }
                else if(radioPosition.getCheckedRadioButtonId() == R.id.radioBottom){

                    toast.setGravity(Gravity.BOTTOM, 0,0);
                }
                else{
                    Toast.makeText(Activity_toast.this, "Please select TOAST POSITION first", Toast.LENGTH_SHORT).show();
                    return;
                }

                toast.show();
            }
        });


        btnShowCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void setButtons(){

        btnToastClose = (Button) findViewById(R.id.btnToastClose);
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
        btnShowCustomToast = (Button) findViewById(R.id.btnShowCustomToast);
    }

}
