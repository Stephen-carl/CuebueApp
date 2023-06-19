package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    LinearLayout mang_button, tran_button, top_button, view_button;
    TextView switchText;
    String on, off;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //ids
        mang_button = findViewById(R.id.dashboard_manage_profile);
        tran_button = findViewById(R.id.dashboard_transfers);
        top_button = findViewById(R.id.dashboard_mobile_top_up);
        view_button = findViewById(R.id.dashboard_view_balance);

        mang_button.setOnClickListener(view -> {
            Intent mang_intent = new Intent(this, Sign_Up.class);
            startActivity(mang_intent);
        });
        tran_button.setOnClickListener(view -> {
            Intent tran_intent = new Intent(this, Transfers.class);
            startActivity(tran_intent);
        });
        top_button.setOnClickListener(view -> {
            Intent top_intent = new Intent(this, Mobile_Top_Up.class);
            startActivity(top_intent);
        });
        view_button.setOnClickListener(view -> {
            Intent view_intent = new Intent(this, Main_View_Balance.class);
            startActivity(view_intent);
        });


    }
    int counter = 0;

    @Override
    public void onBackPressed() {
        counter++;
        if (counter==2){
            super.onBackPressed();
        }
    }
}