package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String username = "Ewa";
    private final String email = "EwaStonoga@gmail.com";
    private final String phone = "123323789";
    private final String password = "123456789";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Witaj, " + username + "!");

        Button Profile = findViewById(R.id.Client_profile);
        Button Buy_ticket = findViewById(R.id.Buy_ticket);
        Button Timetable = findViewById(R.id.timetable);
        Button SendReport = findViewById(R.id.Create_report);
        Profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ClientProfile.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("password", password);
            startActivity(intent);
        });
        SendReport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });
        Buy_ticket.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BuyTicketActivity.class);
            startActivity(intent);
        });
        Timetable.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimetableActivity.class);
            startActivity(intent);
        });

    }
}


