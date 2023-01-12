package com.example.test123;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

=======
import android.widget.Button;
import android.content.Intent;
>>>>>>> main
import androidx.appcompat.app.AppCompatActivity;


public class TicketDetailsActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
<<<<<<< HEAD
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Szczegóły biletu");
        View contentView = vi.inflate(R.layout.ticket_details, insertPoint);



        Button previous = header.findViewById(R.id.previous);
=======
        setContentView(R.layout.ticket_details);



        Button previous = findViewById(R.id.previous);
>>>>>>> main
        previous.setOnClickListener(view -> finish());
    }
}
