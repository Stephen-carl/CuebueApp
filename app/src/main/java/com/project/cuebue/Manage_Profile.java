package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Manage_Profile extends AppCompatActivity {

    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);

        add_button = findViewById(R.id.manage_profile_add);

        //intent
        add_button.setOnClickListener(view -> {
            Intent add_intent = new Intent(this, Add_Profile.class);
            startActivity(add_intent);
        });

    }
}