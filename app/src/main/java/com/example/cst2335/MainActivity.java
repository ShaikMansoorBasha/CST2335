package com.example.cst2335;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * Created By Shaik
 * 19/01/2023
 */
public class MainActivity extends AppCompatActivity {
    Button btn_Click;
    Switch btn_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);
        btn_Click = (Button) findViewById(R.id.btn_click);
        btn_switch = (Switch) findViewById(R.id.btn_switch);
        //OnClickListener to show Toast
        btn_Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.here_is_more_information), Toast.LENGTH_LONG).show();
            }
        });
        //OnClickListener to show SnackBar
        btn_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showSnackBar(R.string.the_switch_now_on, buttonView, true);
                } else {
                    showSnackBar(R.string.the_switch_now_off, buttonView, false);
                }

            }
        });
    }

    private void showSnackBar(int the_switch_now_off, CompoundButton buttonView, boolean isChecked) {
        Snackbar snackbar = Snackbar.make(buttonView, the_switch_now_off, Snackbar.LENGTH_LONG).setAction(R.string.undo, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked) {
                    btn_switch.setChecked(false);
                }
            }
        });

        snackbar.show();

    }


}