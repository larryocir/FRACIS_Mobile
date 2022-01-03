package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FarmerRegistration1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextInputLayout fname, lname, mname, extname, pob, contact, spouse;
    EditText dob;
    DatePickerDialog datePickerDialog;
    Spinner civil_status, genderspin, spinbarangay;
    Button save;
    DBHelper DB;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_registration1);

        DB = new DBHelper(this);

        save = findViewById(R.id.btnSave);

        fname = findViewById(R.id.text_input_Fname);
        mname = findViewById(R.id.text_input_Mname);
        lname = findViewById(R.id.text_input_Lname);
        extname = findViewById(R.id.text_input_Ename);
        dob = findViewById(R.id.date_picker_dialog);
        pob = findViewById(R.id.text_input_pob);
        contact = findViewById(R.id.text_input_Contactnumber);
        spouse = findViewById(R.id.text_input_spouse);


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



        //CIVIL STATUS
        genderspin = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adaptergender = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adaptergender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderspin.setAdapter(adaptergender);
        genderspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String gen = parent.getItemAtPosition(position).toString();
                if (gen == "Married"){
                    spouse.setEnabled(false);
                }else{
                    spouse.setEnabled(true);
                }

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

    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){

        month +=1;
        String date = dayOfMonth + "/" + month + "/" + year;
           if (date == null){
               date = "";
               //glovar.setGender(date);
           }else{
               dob.setText(date);
              // glovar.setDate_of_Birth(date);
           }

    }

    public void confirmSave(View v) {
        /*String civil_status_text = civil_status.getSelectedItem().toString();
        lname.getEditText().setText(civil_status_text);
        String barangay_text = spinbarangay.getSelectedItem().toString();
        mname.getEditText().setText(barangay_text);*/
        String fnameTXT = fname.getEditText().getText().toString();
        String mnameTXT = mname.getEditText().getText().toString();
        String lnameTXT = lname.getEditText().getText().toString();
        String extnameTXT = extname.getEditText().getText().toString();
        String barangayTXT = spinbarangay.getSelectedItem().toString();
        String genderTXT = genderspin.getSelectedItem().toString();
        String dobTXT = dob.getText().toString();
        String pobTXT = pob.getEditText().getText().toString();
        String contactTXT = contact.getEditText().getText().toString();
        String civilstatusTXT = civil_status.getSelectedItem().toString();
        String spouseTXT = spouse.getEditText().getText().toString();


        Boolean checkinsertdata = DB.insertuserdata(fnameTXT, mnameTXT, lnameTXT, extnameTXT, barangayTXT, genderTXT, dobTXT, pobTXT, contactTXT, civilstatusTXT, spouseTXT);
        if (checkinsertdata == true) {
            Toast.makeText(FarmerRegistration1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(FarmerRegistration1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
        }
        /*Intent farmform = new Intent(FarmerRegistration1.this,FarmerRegistration2.class);
        startActivity(farmform);*/

    }





}