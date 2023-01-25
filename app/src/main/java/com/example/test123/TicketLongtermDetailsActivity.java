package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class TicketLongtermDetailsActivity extends AppCompatActivity{
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    protected void onCreate(Bundle savedInstanceState) {
        DBHandler dbHandler = new DBHandler(this);
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Kup bilet");
        View contentView = vi.inflate(R.layout.ticket_longterm_details, insertPoint);
        TextView ticketType = contentView.findViewById(R.id.ticket_type);
        TextView ticketPrice = contentView.findViewById(R.id.ticket_price);
        Button BuyTicket = contentView.findViewById(R.id.buy_ticket);
        System.out.println(getIntent().getFloatExtra("price", 0));
        ticketType.setText(getIntent().getStringExtra("ticketType"));
        ticketPrice.setText(String.format("%.2f", getIntent().getDoubleExtra("price", 0)) + " zł");
        BuyTicket.setOnClickListener(view -> {
            dbHandler.buyTicket(getIntent().getStringExtra("ticketType"), (float) getIntent().getDoubleExtra("price", 0), 1, 0, getIntent().getIntExtra("time", 0));
            Toast.makeText(getApplicationContext(), "Bilet zakupiony", Toast.LENGTH_SHORT).show();
            finish();
        });
        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}
