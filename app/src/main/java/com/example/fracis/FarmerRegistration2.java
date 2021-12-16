package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FarmerRegistration2 extends AppCompatActivity {

    TextView gen, brgy, cv, date;
    GloVar glovar = (GloVar) getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_registration2);

        gen = findViewById(R.id.resgender);
        brgy = findViewById(R.id.resbarangay);
        cv = findViewById(R.id.rescivilstatus);
        date = findViewById(R.id.resdate);

        gen.setText(glovar.getGender());
        brgy.setText(glovar.getBarangay());
        cv.setText(glovar.getCivil_Status());
        date.setText(glovar.getDate_of_Birth());



    }
}