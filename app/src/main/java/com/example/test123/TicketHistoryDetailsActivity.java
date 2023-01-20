package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TicketHistoryDetailsActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Szczegóły biletu");
        View contentView = vi.inflate(R.layout.ticket_history_element_big, insertPoint);

        TextView ticketType = contentView.findViewById(R.id.ticket_history_element_type);
        TextView ticketNumber = contentView.findViewById(R.id.ticket_history_element_line_number);

        TextView ticketDate = contentView.findViewById(R.id.ticket_history_element_date);

        ticketType.setText(getIntent().getStringExtra("ticketType"));
        ticketNumber.setText(Integer.toString(getIntent().getIntExtra("ticketLine", 0)));
        ticketDate.setText(getIntent().getStringExtra("ticketCreationDate"));

        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


