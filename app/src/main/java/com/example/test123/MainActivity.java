package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public User user;
    public DBHandler dbHandler;
    TextView greetings;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(MainActivity.this);
        user = dbHandler.getUser();
        super.onCreate(savedInstanceState);


        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Witaj, " + user.getUsername() + "!");

        Button buyTicket = findViewById(R.id.buy_ticket);
        buyTicket.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BuyTicketActivity.class);
            startActivity(intent);
        });

        Button Profile = findViewById(R.id.client_profile);
        Profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ClientProfile.class);
            intent.putExtra("username", user.getUsername());
            intent.putExtra("email", user.getEmail());
            intent.putExtra("phone", user.getPhone());
            intent.putExtra("password", user.getPassword());
            intent.putExtra("discount", user.getDiscount());
            startActivity(intent);
        });

        Button SendReport = findViewById(R.id.create_report);
        SendReport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });


    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onResume(){
        super.onResume();
        user = dbHandler.getUser();
    }
}


