package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FarmerRegistration1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText dob;
    DatePickerDialog datePickerDialog;
    Spinner civil_status, genderspin, spinbarangay;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_registration1);

        dob = findViewById(R.id.date_picker_dialog);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //DATE PICKER BDAY
        datePickerDialog = new DatePickerDialog(FarmerRegistration1.this,  this, year,month, day);
        datePickerDialog.setCancelable(true);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        //CIVIL STATUS
        civil_status = findViewById(R.id.spinner_civilstatus);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.civil_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        civil_status.setAdapter(adapter);
        civil_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String civilstatus = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), civilstatus, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //CIVIL STATUS
        genderspin = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adaptergender = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adaptergender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspin.setAdapter(adaptergender);
        genderspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String gender = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), gender, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //BARANGAY
        spinbarangay= findViewById(R.id.spinner_barangay);
        ArrayAdapter<CharSequence> adapterbarangay = ArrayAdapter.createFromResource(this, R.array.barangay, android.R.layout.simple_spinner_item);
        adapterbarangay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinbarangay.setAdapter(adapterbarangay);
        spinbarangay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String brgy = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), brgy, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

       public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){

        month +=1;
        String date = dayOfMonth + "/" + month + "/" + year;
        dob.setText(date);

    }



}