package com.example.test123;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicketOnewayActivity extends AppCompatActivity {
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
        View contentView = vi.inflate(R.layout.ticket_oneway_menu, insertPoint);

        Button jednoliniowy_ul = contentView.findViewById(R.id.jednoliniowy_ulgowy);
        jednoliniowy_ul.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button jednoliniowy = contentView.findViewById(R.id.jednoliniowy_normalny);
        jednoliniowy.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
            startActivity(intent);
        });
        Button ulgowy_30 = contentView.findViewById(R.id.ulgowy_30);
        ulgowy_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button normalny_30 = contentView.findViewById(R.id.normalny_30);
        normalny_30.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button ulgowy_60 = contentView.findViewById(R.id.ulgowy_60);
        ulgowy_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketTemporaryDetailsActivity.class);
            startActivity(intent);
        });
        Button normalny_60 = contentView.findViewById(R.id.normalny_60);
        normalny_60.setOnClickListener(v -> {
            Intent intent = new Intent(TicketOnewayActivity.this, TicketTemporaryDetailsActivity.class);
            startActivity(intent);
        });


        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


