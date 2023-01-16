package com.example.test123;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicketOnewayActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        DBHandler db = new DBHandler(this);
        double discount = 1 - db.getDiscount() / 100.0;

        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_one_way);
        TextView header_title = findViewById(R.id.header_title);
        header_title.setText("Kup bilet");

        System.out.println(discount);
        Button jednoliniowy_ul = findViewById(R.id.jednoliniowy_ulgowy);
        jednoliniowy_ul.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 4.00 * discount);
            intent.putExtra("ticketType", "Jednoliniowy ulgowy");
            startActivity(intent);
        });
        Button jednoliniowy = findViewById(R.id.jednoliniowy_normalny);
        jednoliniowy.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 4.00);
            intent.putExtra("ticketType", "Jednoliniowy");
            startActivity(intent);
        });
        Button ulgowy_30 = findViewById(R.id.ulgowy_30);
        ulgowy_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 4.00 * discount);
            intent.putExtra("ticketType", "Ulgowy 30 minut");
            startActivity(intent);
        });
        Button normalny_30 = findViewById(R.id.normalny_30);
        normalny_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 4.00);
            intent.putExtra("ticketType", "Normalny 30 minut");
            startActivity(intent);
        });
        Button ulgowy_60 = findViewById(R.id.ulgowy_60);
        ulgowy_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 7.00 * discount);
            intent.putExtra("ticketType", "Ulgowy 60 minut");
            startActivity(intent);
        });
        Button normalny_60 = findViewById(R.id.normalny_60);
        normalny_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            intent.putExtra("price", 7.00);
            intent.putExtra("ticketType", "Normalny 60 minut");
            startActivity(intent);
        });

        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


