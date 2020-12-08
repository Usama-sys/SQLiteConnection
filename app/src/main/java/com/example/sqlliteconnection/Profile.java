package com.example.sqlliteconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

//    TextView userEmail;
    Button buttonLogout;
//    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        userEmail = findViewById(R.id.userEmail);
        buttonLogout = findViewById(R.id.buttonLogout);
//        dbHelper = new DBHelper(this);

//        Cursor cursor = dbHelper.viewData();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("email"+cursor.getString(0));
//        userEmail.setText("Welcome "+stringBuilder);


        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}