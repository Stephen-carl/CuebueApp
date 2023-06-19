package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Main_View_Balance extends AppCompatActivity {

    Button button;
    TextInputEditText pinEditText;
    String PinEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_balance);

        //ids
        button = findViewById(R.id.balance_back);
        pinEditText = findViewById(R.id.balancer_password);
        PinEditText = pinEditText.getText().toString().trim();
        //done

        //intent
        button.setOnClickListener(view -> {
            if (PinEditText == "") {
                Toast.makeText(this, "Please Input Your Pin", Toast.LENGTH_LONG).show();
            } else {
                balanceSms();
            }
        });

    }

    public void balanceSms() {
        //main message
        String passworrdd = pinEditText.getText().toString();
        String mainMessage = "Balance, " + passworrdd ;
        //the server number
        String numb = "+2348104714353";

        //sms manager
        SmsManager appSmsManager = SmsManager.getDefault();
        appSmsManager.sendTextMessage(numb,null, mainMessage, null,null);

        Toast.makeText(this, "Your Request is being processed. You will receive a message shortly!!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Main_View_Balance.this, Dashboard.class);
        startActivity(intent);
    }
}