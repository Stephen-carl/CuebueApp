package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.cuebue.dtb.DBHelper;
import com.project.cuebue.dtb.UserDetails;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button login_button;
    TextView password_text;
    TextInputEditText edit_bvn_ph, edit_app_password;
    String edit_ph_bvn, edit_passwrd_app;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ref db
        dbHelper = new DBHelper(this);
        dbHelper.OpenDB();

        //ids
        login_button = findViewById(R.id.login_button);
        password_text = findViewById(R.id.login_forgot_pass);
        edit_bvn_ph = findViewById(R.id.login_bvn);
        edit_app_password = findViewById(R.id.login_password);
        edit_ph_bvn = edit_bvn_ph.getText().toString();
        edit_passwrd_app = edit_app_password.getText().toString();
        //done

        //intent
        login_button.setOnClickListener(view -> {

        });

        //intent for text
        password_text.setOnClickListener(view -> {
            Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
        });

    }
}