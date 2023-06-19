package com.project.cuebue;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Mobile_Top_Up extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mobile_spinner;
    String mobile_spinner_text, TopUP_phone, TopUP_amount, TopUP_pin, TOP_Network;
    private Button mobile_button;
    TextInputEditText amount_edit, phone_edit, pinaclllle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_top_up);

        //ids
        mobile_spinner = findViewById(R.id.mobile_top_up_acct_profile);
        mobile_button = findViewById(R.id.mobile_top_up_button);
        amount_edit = findViewById(R.id.mobile_top_up_amount);
        phone_edit = findViewById(R.id.mobile_top_up_phone_number);
        pinaclllle = findViewById(R.id.pinny);
        //done

        //condition and Intent
        mobile_button.setOnClickListener(view -> {
            //initiate top-up
            TopUP();
        });

        //set spinner
        ArrayAdapter<CharSequence> mobile_adapter = ArrayAdapter.createFromResource(this, R.array.Networks, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        mobile_adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        mobile_spinner.setAdapter(mobile_adapter);
        mobile_spinner.setOnItemSelectedListener(this);
        mobile_spinner_text = mobile_spinner.getSelectedItem().toString();


    }

    private void TopUP() {
        TopUP_phone = Objects.requireNonNull(phone_edit.getText()).toString();
        TopUP_amount = Objects.requireNonNull(amount_edit.getText()).toString();
        TopUP_pin = Objects.requireNonNull(pinaclllle.getText().toString());
        if (TopUP_phone.length() < 11) {
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_LONG).show();
        }
        else if (TopUP_amount.isEmpty()) {
            Toast.makeText(this, "Input Amount", Toast.LENGTH_LONG).show();
        }
        else if (TopUP_pin.isEmpty()){
            Toast.makeText(this, "Input PIN", Toast.LENGTH_LONG).show();
        }
       else {
           TOP_Network = mobile_spinner_text;
                //main message
                String mainMessage = "TopUP, " + TOP_Network + ", " + TopUP_phone + ", " + TopUP_amount + ", " + TopUP_pin;
                //the server number
                String numb = "+2348104714353";

                //sms manager
                SmsManager appSmsManager = SmsManager.getDefault();
                appSmsManager.sendTextMessage(numb,null, mainMessage, null,null);

            Toast.makeText(this, "Your Transaction is being Processed!!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Mobile_Top_Up.this, Dashboard.class);
                startActivity(intent);
        }
    }

    //for spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mobile_spinner_text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        adapterView.setSelection(0);
        mobile_spinner_text = adapterView.getItemAtPosition(0).toString();
    }
}

//TODO
/*
Remember to put a logic to help detect with number is owned by a network provider
Remember to change the spinner to profile after the database is been created
 */