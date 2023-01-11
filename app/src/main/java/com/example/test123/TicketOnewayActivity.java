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

        Button jednoliniowyUl = findViewById(R.id.Jednoliniowy_ulgowy);
        jednoliniowyUl.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button jednoliniowy = findViewById(R.id.Jednoliniowy_normalny);
        jednoliniowy.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button Ulgowy_30 = findViewById(R.id.Ulgowy_30);
        Ulgowy_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button Normalny_30 = findViewById(R.id.Normalny_30);
        Normalny_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button Ulgowy_60 = findViewById(R.id.Ulgowy_60);
        Ulgowy_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button Normalny_60 = findViewById(R.id.Normalny_60);
        Normalny_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });


        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


