package com.project.cuebue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.cuebue.dtb.DBConnector;
import com.project.cuebue.dtb.DBHelper;
import com.project.cuebue.dtb.UserDetails;

public class Add_Profile extends AppCompatActivity {

    Spinner add_profile_spinner;
    Button add_pro_button;
    //string for spinner
    String pro_text;
    TextView acct_name_text;
    TextInputEditText add_acct_edit, add_acct_ph_edit, add_nickname_edit, add_pin_edit;
    UserDetails userDetails;

    private DBHelper dbHelpers;
    private DBConnector dbConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        //ref myDBHelper
        dbHelpers = new DBHelper(Add_Profile.this);
        dbHelpers.OpenDB();

        //ids
        //add_profile_spinner = findViewById(R.id.add_profiler_bank_spinner);
        add_pro_button = findViewById(R.id.add_profile_done);
        add_acct_edit = findViewById(R.id.add_profile_acct_no);
        add_acct_ph_edit = findViewById(R.id.add_profile_ph_no);
        add_nickname_edit = findViewById(R.id.add_profile_nickname);
        add_pin_edit = findViewById(R.id.add_profile_pin);
        acct_name_text = findViewById(R.id.add_profile_acct_name);
        //done

        //condition and intent
        add_pro_button.setOnClickListener(view -> {

            Intent add_profile_intent = new Intent(this, Dashboard.class);
            startActivity(add_profile_intent);

//            String pro_acct = add_acct_edit.getText().toString();
//            String pro_acct_Ph_no = add_acct_ph_edit.getText().toString();
//            //String pro_nickname = add_nickname_edit.getText().toString();
//            String pro_pin = add_pin_edit.getText().toString();
//            //String pro_acct_name = acct_name_text.getText().toString();
//            String pro_bvn = userDetails.getBVN();
//            int pro_id = 1;
//            int pro_ID = pro_id++;
//
//            if (pro_acct.equals("")||pro_acct_Ph_no.equals("")|| pro_pin.equals("")) {
//                Toast.makeText(this, "Input all details", Toast.LENGTH_SHORT).show();
//            }
//            else {
//
//                ProfileDetails profileDetail = new ProfileDetails(pro_ID,pro_bvn,null,pro_pin,pro_acct,pro_acct_Ph_no,null );
//                if (dbHelpers.AddPro(profileDetail)) {
//                    Toast.makeText(this, "Added Successful", Toast.LENGTH_LONG).show();
//                    Intent add_profile_intent = new Intent(this, Dashboard.class);
//                    startActivity(add_profile_intent);
//                }
//                else {
//                    Toast.makeText(this, "Sign-Up Failed", Toast.LENGTH_SHORT).show();
//                }
//            }

        });

//        ArrayAdapter<CharSequence> add_adapter = ArrayAdapter.createFromResource(this, R.array.banks_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        add_adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        add_profile_spinner.setAdapter(add_adapter);
//        add_profile_spinner.setOnItemSelectedListener(this);



    }

//    private void checkSpinner() {
//        if (pro_text.equals(add_profile_spinner.getItemAtPosition(0))) {
//            Toast.makeText(this, "Choose a bank", Toast.LENGTH_LONG).show();
//        }
//        else {
//            Intent add_profile_intent = new Intent(this, Dashboard.class);
//            startActivity(add_profile_intent);
//        }
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        pro_text = add_profile_spinner.getItemAtPosition(i).toString();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//        adapterView.setSelection(0);
//
//    }
}