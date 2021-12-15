package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    ImageView imageview1, imageview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageview1 = findViewById(R.id.imageView);
        imageview2 = findViewById(R.id.imageView2);

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent farmform = new Intent(Home.this,FarmerRegistration1.class);
                startActivity(farmform);
            }
        });

        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newuser = new Intent(Home.this, AddNewUser.class);
                startActivity(newuser);
            }
        });
    }
}