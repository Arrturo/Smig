package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_buy);

        Button jednorazowy = findViewById(R.id.jednorazowy);
        jednorazowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button krotkookresowy = findViewById(R.id.krotkookresowy);
        krotkookresowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button miesieczny = findViewById(R.id.miesieczny);
        miesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button trzymiesieczny = findViewById(R.id.trzymiesieczny);
        trzymiesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button roczny = findViewById(R.id.roczny);
        roczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });


        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());

    }
}
