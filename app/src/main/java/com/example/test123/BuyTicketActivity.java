package com.example.test123;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class BuyTicketActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Kup Bilet");
        View contentView = vi.inflate(R.layout.ticket_menu, insertPoint);


        Button jednorazowy = contentView.findViewById(R.id.jednorazowy);
        jednorazowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketOnewayActivity.class);
            startActivity(intent);
        });
        Button krotkookresowy = contentView.findViewById(R.id.krotkookresowy);
        krotkookresowy.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketTemporaryActivity.class);
            startActivity(intent);
        });
        Button miesieczny = contentView.findViewById(R.id.miesieczny);
        miesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketLongtermDetailsActivity.class);
            startActivity(intent);
        });
        Button trzymiesieczny = contentView.findViewById(R.id.trzymiesieczny);
        trzymiesieczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketLongtermDetailsActivity.class);
            startActivity(intent);
        });
        Button roczny = contentView.findViewById(R.id.roczny);
        roczny.setOnClickListener(v -> {
            Intent intent = new Intent(BuyTicketActivity.this, TicketLongtermDetailsActivity.class);
            startActivity(intent);
        });


        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());

    }
}
