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

        Button profile = findViewById(R.id.client_profile);
        Button buyTicket = findViewById(R.id.buy_ticket);
        Button timetable = findViewById(R.id.timetable);
        Button sendReport = findViewById(R.id.Create_report);
        Button ticketHistory = findViewById(R.id.ticket_history);

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ClientProfile.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("password", password);
            startActivity(intent);
        });
        sendReport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });
        buyTicket.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BuyTicketActivity.class);
            startActivity(intent);
        });
        timetable.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TimetableActivity.class);
            startActivity(intent);
        });
        ticketHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TicketHistoryActivity.class);
            startActivity(intent);
        });

    }
}


