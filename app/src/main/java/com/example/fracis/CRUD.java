package com.example.fracis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CRUD extends AppCompatActivity {

    Button addnew, viewinfo, importdata;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        DB = new DBHelper(this);
        addnew = findViewById(R.id.btnAdd);
        viewinfo = findViewById(R.id.btnView);
        importdata = findViewById(R.id.btnImport);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent farmform = new Intent(CRUD.this,FarmerRegistration1.class);
                startActivity(farmform);
            }
        });

        viewinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });


    }
}