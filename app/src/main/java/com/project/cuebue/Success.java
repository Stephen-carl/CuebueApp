package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Success extends AppCompatActivity {

    Button button;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        button = findViewById(R.id.success_button);
        text = findViewById(R.id._success_receipt);

        //intent
        button.setOnClickListener(view -> {
            Intent success_intent = new Intent(this, Dashboard.class);
            startActivity(success_intent);
        });

        //toast
        text.setOnClickListener(view -> {
            Toast.makeText(this, "Receipt Printed", Toast.LENGTH_SHORT).show();
        });

    }
}