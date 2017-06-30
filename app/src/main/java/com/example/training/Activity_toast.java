package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_toast extends AppCompatActivity {

    private final String title = "Activity: TOAST";
    private Button btnToastClose, btnShowToast, btnShowCustomToast;
    private RadioGroup radioDuration, radioPosition;
    private int duration;
    private String text;
    private Toast toast, customToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        this.setTitle(title);
        setButtons();
        radioDuration = (RadioGroup ) findViewById(R.id.radioDuration);
        radioPosition = (RadioGroup ) findViewById(R.id.radioPosition);

        //Close the activity
        btnToastClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Shows a regular toast
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = "This is regular toast";
                showToast(toast, true);
            }
        });

        //Shows a custom toast
        btnShowCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = "This is custom toast";
                customToast = new Toast(getApplicationContext());
                showToast(customToast, false);

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast_layout, null);
                customToast.setView(layout);

                TextView textContent = (TextView) layout.findViewById(R.id.textContent);
                textContent.setText(text);

                customToast.show();
            }
        });
    }

    //Create buttons
    private void setButtons(){

        btnToastClose = (Button) findViewById(R.id.btnToastClose);
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
        btnShowCustomToast = (Button) findViewById(R.id.btnShowCustomToast);
    }

    //Set toast duration
    private void setDuration(){

        if(radioDuration.getCheckedRadioButtonId() == R.id.radioShort){

            duration = Toast.LENGTH_SHORT;
            text += ": SHORT";
        }
        else if(radioDuration.getCheckedRadioButtonId() == R.id.radioLong){

            duration = Toast.LENGTH_LONG;
            text += ": LONG";
        }
        else{

            Toast.makeText(Activity_toast.this, "Please select TOAST DURATION first", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //Set toast position
    private void setPosition(Toast toastName){

        if(radioPosition.getCheckedRadioButtonId() == R.id.radioCenter){

            toastName.setGravity(Gravity.CENTER, 0,0);
        }
        else if(radioPosition.getCheckedRadioButtonId() == R.id.radioBottom){

            toastName.setGravity(Gravity.BOTTOM, 0,0);
        }
        else{

            Toast.makeText(Activity_toast.this, "Please select TOAST POSITION first", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //Show toast message
    private void showToast(Toast toastName, boolean isToast){

        //Set toast duration
        setDuration();

        if(isToast){
            //Create the toast
            toastName = Toast.makeText(getApplicationContext(), text, duration);
        }

        //Set toast position
        setPosition(toastName);

        if(isToast){
            //Display the toast
            toastName.show();
        }
    }
}
