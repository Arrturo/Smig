package com.example.test123;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class FineMenuActivitiy extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Mandaty");
        View contentView = vi.inflate(R.layout.fine, insertPoint);

        Button fineHistory = contentView.findViewById(R.id.historia_mandatow);
        Button finePay = contentView.findViewById(R.id.oplac_mandat);

        fineHistory.setOnClickListener(v -> {
            Intent intent = new Intent(FineMenuActivitiy.this, FineHistoryActivity.class);
            startActivity(intent);
        });

        finePay.setOnClickListener(v -> {
            Intent intent = new Intent(FineMenuActivitiy.this, FinePayDetailsActivity.class);
            startActivity(intent);
        });

        Button previous = header.findViewById(R.id.previous);

        previous.setOnClickListener(view -> finish());
    }
}
