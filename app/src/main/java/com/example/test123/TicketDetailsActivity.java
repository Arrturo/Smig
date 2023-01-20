package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class TicketDetailsActivity extends AppCompatActivity {
    TextView ticketType;
    TextView ticketPrice;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        double price = getIntent().getDoubleExtra("price", 0);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Szczegóły biletu");
        View contentView = vi.inflate(R.layout.ticket_details, insertPoint);


        Button previous = header.findViewById(R.id.previous);
        ticketType = contentView.findViewById(R.id.ticket_type);
        ticketPrice = contentView.findViewById(R.id.ticket_price);
        ticketType.setText(getIntent().getStringExtra("ticketType"));
        ticketPrice.setText(String.format("%.2f", price) + " zł");
        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}

