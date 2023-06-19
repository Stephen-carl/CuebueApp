package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {

    Button ot_button, ot_resend;
    TextView countdown_text, phone_editText;
    CountDownTimer countDownTimer;
    Sign_Up sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        //ids
        ot_button = findViewById(R.id.otp_button);
        ot_resend = findViewById(R.id.otp_resend);
        phone_editText = findViewById(R.id.otp_phone_number);
        countdown_text = findViewById(R.id.tv_coundown);
        countDown();

        //set otp text
        String OTPPhNo = getIntent().getStringExtra("number");
        phone_editText.setText(OTPPhNo);

        //intent
        ot_button.setOnClickListener(view -> {
            Intent ot_intent = new Intent(this, Dashboard.class);
            startActivity(ot_intent);
        });

        //toast
        ot_resend.setOnClickListener(view -> {
            Toast.makeText(this, "Code Sent", Toast.LENGTH_SHORT).show();
        });

    }

    private void countDown() {
        countDownTimer = new CountDownTimer(1000 * 60 * 2, 1000) {
            @Override
            public void onTick(long l) {
                String text = String.format(Locale.getDefault(), "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(l) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(l) % 60);
                countdown_text.setText(text);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }


}