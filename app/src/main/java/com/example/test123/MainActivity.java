package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private User user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHandler dbHandler = new DBHandler(MainActivity.this);
        user = dbHandler.getUser();

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Witaj, " + user.getUsername() + "!");

        Button Profile = (Button) findViewById(R.id.button1);
        Button SendReport = (Button) findViewById(R.id.button3);
        Profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ClientProfile.class);
            intent.putExtra("username", user.getUsername());
            intent.putExtra("email", user.getEmail());
            intent.putExtra("phone", user.getPhone());
            intent.putExtra("password", user.getPassword());
            startActivity(intent);
        });
        SendReport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });

    }
}


