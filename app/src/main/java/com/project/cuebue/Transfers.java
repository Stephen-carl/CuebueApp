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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Transfers extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 1 ;
    String profile_text, bank_text;
    private Button button;
    TextInputEditText acct_no_edit, acct_amount_edit, transferPin;
    String Acct_No, Acct_Amount, TransferPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfers);

        button = findViewById(R.id.transfer_button);
        transferPin = findViewById(R.id.transfer_password);
        acct_no_edit = findViewById(R.id.transfer_acct_no);
        acct_amount_edit = findViewById(R.id.transfer_amount);
        //done

        //condition and Intent
        button.setOnClickListener(view -> {
            transfer();
            //launch the permission
            //callPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
        });
    }



    //checking the parameters for making the transfer
    private void transfer() {
        Acct_No = Objects.requireNonNull(acct_no_edit.getText()).toString();
        Acct_Amount = Objects.requireNonNull(acct_amount_edit.getText()).toString();
        TransferPin = Objects.requireNonNull(transferPin.getText().toString());
        if (Acct_No.length() < 10) {
            Toast.makeText(this, "Invalid Account Number", Toast.LENGTH_LONG).show();
        }
        else if (Acct_Amount.isEmpty()||TransferPin.isEmpty()) {
            Toast.makeText(this, "Input Details", Toast.LENGTH_LONG).show();
        }
        //check for permission
//        else if (ActivityCompat.checkSelfPermission(getApplicationContext(),
//                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
//            }
        else {
            //main message
            String mainMessage = "Transfer, " + Acct_No + ", " + Acct_Amount + ", " + TransferPin;
            //the server number
            String numb = "+2348104714353";

            //sms manager
            SmsManager appSmsManager = SmsManager.getDefault();
            appSmsManager.sendTextMessage(numb,null, mainMessage, null,null);

            Toast.makeText(this, "Your Transaction is being Processed!!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Transfers.this, Dashboard.class);
            startActivity(intent);
        }
    }
}

/*procedure
1. find ids
2. fill in the spinner and assign to a string
3. set the spinner methods
4. ask fot permission
5. when button is clicked;
- it brings the permission box
- once it is granted;
- it goes to the checkBankSpinner() method
- then goes to the transfer() method
- inside the transfer method it will check if the permission is granted
- then run an intent pointing to Uri ussd method that takes in two strings
TODO
Remember ro add the logic of same bank transfers after the database is working
Remember to change the spinner to profile after the database is been created
*/