package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Top_Up_Preview extends AppCompatActivity {

    Button button;
    TextInputEditText top_pass_edit;
    TextView amount_text, phone_text, acct_no_text, acct_name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_preview);

        //ids
        button = findViewById(R.id.topUp_done);
        top_pass_edit = findViewById(R.id.topUp_password);
        amount_text = findViewById(R.id.topUp_amount);
        phone_text = findViewById(R.id.topUp_receiver_ph_no);
        acct_no_text = findViewById(R.id.topUp_user_acct_no);
        acct_name_text = findViewById(R.id.topUp_user_acct_name);
        //done

        //intent
        button.setOnClickListener(view -> {
            Intent top_intent = new Intent(this, Success.class);
            startActivity(top_intent);
        });

    }
}