package com.example.sqlliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail,editTextPassword;
    Button buttonSignup,buttonLogin;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignup);
        buttonLogin = findViewById(R.id.buttonLogin);
        dbHelper = new DBHelper(this);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegistration();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

    }

    private void userRegistration() {


        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if(email.equals("")){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        }
        if(password.equals("")){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }

            Boolean checkEmail = dbHelper.checkEmail(email);
            if(checkEmail==false){
                Boolean checkInsert = dbHelper.insertData(email,password);
                if(checkInsert==true){

                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show();
                }
            }else{

                Toast.makeText(this, "Email Already Exists", Toast.LENGTH_SHORT).show();
            }



    }
}