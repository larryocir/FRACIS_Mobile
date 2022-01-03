package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FarmerRegistration2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_registration2);







    }
    public void confirmNext2(View v) {
        Intent farmform = new Intent(FarmerRegistration2.this,FarmerRegistration3.class);
        startActivity(farmform);
    }
}