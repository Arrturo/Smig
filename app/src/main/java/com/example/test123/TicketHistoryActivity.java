package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class TicketHistoryActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);

        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Historia Biletów");


        for (int row = 0; row < 12; row++) {
            if (row % 2 == 0) {
                View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
                View ticketHistory = vi.inflate(R.layout.ticket_history_element_small, insertPointOne);
                ticketHistory.setId(row);
                TextView ticketElementLineNumber = ticketHistory.findViewById(R.id.ticket_history_element_line_number);
                String valueOfBusStop = String.valueOf(row);
                valueOfBusStop = "Numer Lini" + valueOfBusStop;
                ticketElementLineNumber.setText(valueOfBusStop); // Zamiast ValueOfId numer lini w stringu
                TextView ticketElementDate = ticketHistory.findViewById(R.id.ticket_history_element_date);
                ticketElementDate.setText("2022-04-20"); // Zamiast Stringa data wystawienia biletu w stringu
                ticketHistory.setOnClickListener(v -> {
                    Intent intent = new Intent(TicketHistoryActivity.this, TicketHistoryDetailsActivity.class);
                    startActivity(intent);
                });
                Button previousActivity = header.findViewById(R.id.previous);
                previousActivity.setOnClickListener(view -> {
                    // Finish the current activity and return to the previous one
                    finish();
                });
            }
        }
    }
}