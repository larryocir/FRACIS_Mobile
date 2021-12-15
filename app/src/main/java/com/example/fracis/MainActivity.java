package com.example.fracis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout user, password;
    Button btn_login;
    TextView invalid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login =findViewById(R.id.btnlogin);
        user = findViewById(R.id.text_input_user);
        password = findViewById(R.id.text_input_password);
        invalid = findViewById(R.id.validation);

        closekeyboard();
       // btn_login.setOnClickListener(new View.OnClickListener() {
        //    @Override

           // public void onClick(View v) {

                //if (user.getEditText().getText().toString().equals("admin") && password.getEditText().getText().toString().equals("admin")){
               //     Intent login = new Intent(MainActivity.this, Home.class);
               //     startActivity(login);
              //  }else{
              //      Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
              //  }
          //  }
       // });
    }

    private boolean validateName() {
        String val = user.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            user.setError("Field can not be empty");
            return false;
        } else {
            user.setError(null);
            user.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();


        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void confirmLogin(View v) {
        if (!validateName() | !validatePassword()){
            invalid.setVisibility(View.INVISIBLE);
            user.getEditText().setText(null);
            password.getEditText().setText(null);
            user.requestFocus();
            closekeyboard();
           return;

        } else {
            if (user.getEditText().getText().toString().equals("admin") && password.getEditText().getText().toString().equals("admin")){
                user.getEditText().setText(null);
                password.getEditText().setText(null);
                user.requestFocus();
                closekeyboard();
                    invalid.setVisibility(View.INVISIBLE);
                    Intent login = new Intent(MainActivity.this, Home.class);
                    startActivity(login);

            }else{
                user.getEditText().setText(null);
                password.getEditText().setText(null);
                user.requestFocus();
                     invalid.setVisibility(View.VISIBLE);

                     closekeyboard();
            }
        }




       // String input = "Email: " + user.getEditText().getText().toString();
        //Toast.makeText(this, input,Toast.LENGTH_SHORT).show();
    }

    private void closekeyboard() {
        View view = this.getCurrentFocus();

        //Find the currently focused view, so we can grab the correct window token from it.

        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}