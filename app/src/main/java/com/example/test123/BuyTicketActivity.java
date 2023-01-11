package com.example.test123;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_menu);

        Button jednorazowy = findViewById(R.id.Jednorazowy);
        jednorazowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button krotkookresowy = findViewById(R.id.Krotkookresowy);
        krotkookresowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button miesieczny = findViewById(R.id.Miesieczny);
        miesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button trzymiesieczny = findViewById(R.id.Trzymiesieczny);
        trzymiesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button roczny = findViewById(R.id.Roczny);
        roczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });


        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());

    }
}
