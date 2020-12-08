package com.example.sqlliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText editTextLoginEmail,editTextloginPassword;
    Button Login;
    TextView textViewSignup;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextloginPassword = findViewById(R.id.editTextloginPassword);
        Login = findViewById(R.id.Login);
        textViewSignup = findViewById(R.id.textViewSignup);

        dbHelper = new DBHelper(this);




        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

    private void userLogin() {

        String email = editTextLoginEmail.getText().toString().trim();
        String password = editTextloginPassword.getText().toString().trim();

        if(email.equals("")){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        }
        if(password.equals("")){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }

            Boolean checkEmailPassword = dbHelper.checkEmailPassword(email,password);
            if(checkEmailPassword==true){

                Toast.makeText(this, "Signin successfully", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Login.this,Profile.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }


    }
}