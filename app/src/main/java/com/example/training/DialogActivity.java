package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.training.Dialogs.SimpleDialogFragment;


public class DialogActivity extends AppCompatActivity implements View.OnClickListener{

    private final String title = "Dialog Activity";
    private Button buttonSimpleDialog, buttonCustomDialog, buttonSingleAction, buttonClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        this.setTitle(title);
        setButtons();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.buttonSimpleDialog:
                showSimpleDialog();
                break;
            case R.id.buttonCustomDialog:
                showCustomDialog();
                break;
            case R.id.buttonSingleAction:
                showSingleAction();
                break;
            case R.id.buttonClose:
                finish();

        }
    }

    private void showSimpleDialog(){

        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();
        simpleDialog.show(getSupportFragmentManager(), "This is SimpleDialogFragment");
    }

    private void showCustomDialog(){

    }

    private void showSingleAction(){

    }


    //Set buttons + OnClick listener
    private void setButtons(){

        buttonSimpleDialog = (Button)findViewById(R.id.buttonSimpleDialog);
        buttonSimpleDialog.setOnClickListener(this);

        buttonCustomDialog = (Button)findViewById(R.id.buttonCustomDialog);
        buttonCustomDialog.setOnClickListener(this);

        buttonSingleAction = (Button)findViewById(R.id.buttonSingleAction);
        buttonSingleAction.setOnClickListener(this);

        buttonClose = (Button)findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(this);
    }

}
