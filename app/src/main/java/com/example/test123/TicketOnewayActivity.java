package com.example.test123;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class TicketOnewayActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_oneway_menu);

        Button jednoliniowy_ul = findViewById(R.id.jednoliniowy_ulgowy);
        jednoliniowy_ul.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button jednoliniowy = findViewById(R.id.jednoliniowy_normalny);
        jednoliniowy.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button ulgowy_30 = findViewById(R.id.ulgowy_30);
        ulgowy_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button normalny_30 = findViewById(R.id.normalny_30);
        normalny_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button ulgowy_60 = findViewById(R.id.ulgowy_60);
        ulgowy_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button normalny_60 = findViewById(R.id.normalny_60);
        normalny_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });


        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


