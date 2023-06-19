package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class TransPreview extends AppCompatActivity {

    Button button;
    TextInputEditText password_edit;
    TextView amount_text, user_name_text, user_acct_text, rev_acct_text, rev_name_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_preview);

        //ids
        button = findViewById(R.id.trans_preview_done);
        password_edit = findViewById(R.id.trans_password);
        amount_text = findViewById(R.id.trans_amount);
        user_acct_text = findViewById(R.id.trans_user_acct_no);
        user_name_text = findViewById(R.id.trans_user_acct_name);
        rev_acct_text = findViewById(R.id.trans_receiver_acct_no);
        rev_name_text = findViewById(R.id.trans_receiver_acct_name);
        //done

        //intent
        button.setOnClickListener(view -> {
            Intent preview_intent = new Intent(this, Success.class);
            startActivity(preview_intent);
        });

    }
}