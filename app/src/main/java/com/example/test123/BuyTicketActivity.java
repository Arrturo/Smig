package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketActivity extends AppCompatActivity {
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
        setContentView(R.layout.ticket_buy);


//        Button Profile = (Button) findViewById(R.id.Client_profile);
//        Button SendReport = (Button) findViewById(R.id.Create_report);
        Button Ticket_oneway = findViewById(R.id.jednorazowy);
        Ticket_oneway.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, BuyTicketOnewayActivity.class);
            startActivity(intent);
        });
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}