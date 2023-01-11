package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketOnewayActivity extends AppCompatActivity {
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
        setContentView(R.layout.ticket_oneway_menu);

        Button Ticket_oneway_normal = findViewById(R.id.jednoliniowy_normalny);
        Ticket_oneway_normal.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayDetailsActivity.class);
            startActivity(intent);
        });
        Button Ticket_oneway_reduction = findViewById(R.id.jednoliniowy_ulgowy);
        Ticket_oneway_reduction.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayDetailsActivity.class);
            startActivity(intent);
        });
        Button Ticket_oneway_temporary_30_normal = findViewById(R.id.normalny_30);
        Ticket_oneway_temporary_30_normal.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button  Ticket_oneway_temporary_30_reduction = findViewById(R.id.ulgowy_30);
        Ticket_oneway_temporary_30_reduction.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button  Ticket_oneway_temporary_60_normal = findViewById(R.id.normalny_60);
        Ticket_oneway_temporary_60_normal.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button  Ticket_oneway_temporary_60_reduction = findViewById(R.id.ulgowy_60);
        Ticket_oneway_temporary_60_reduction.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketOnewayActivity.this, BuyTicketOnewayTemporaryDetailsActivity.class);
            startActivity(intent);
        });

//        Button Profile = (Button) findViewById(R.id.Client_profile);
//        Button SendReport = (Button) findViewById(R.id.Create_report);
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}