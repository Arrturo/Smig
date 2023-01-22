package com.example.test123;

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
        TextView header = findViewById(R.id.header_title);
        header.setText("Wybierz rodzaj biletu");
        Button jednorazowy = findViewById(R.id.jednorazowy);

        jednorazowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            intent.putExtra("discount", getIntent().getStringExtra("discount"));
            startActivity(intent);
        });
        Button krotkookresowy = findViewById(R.id.krotkookresowy);
        krotkookresowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketTemporaryActivity.class);
            intent.putExtra("discount", getIntent().getStringExtra("discount"));
            startActivity(intent);
        });
        Button miesieczny = findViewById(R.id.miesieczny);
        miesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketMonthTicketActivity.class);
            intent.putExtra("discount",getIntent().getStringExtra("discount"));
            startActivity(intent);
        });
        Button trzymiesieczny = findViewById(R.id.trzymiesieczny);
        trzymiesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, ThreeMonthTicketActivity.class);
            intent.putExtra("discount", getIntent().getStringExtra("discount"));
            startActivity(intent);
        });
        Button roczny = findViewById(R.id.roczny);
        roczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, YearTicketActivity.class);
            intent.putExtra("discount", getIntent().getStringExtra("discount"));
            startActivity(intent);
        });


        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());

    }
}
