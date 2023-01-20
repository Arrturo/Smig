package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        DBHandler dbHandler = new DBHandler(TicketHistoryActivity.this);

        ArrayList<Ticket> tickets = dbHandler.getTickets();
        for (int row = 0; row < tickets.size(); row++) {

            View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
            pair.setId(row);
            ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
            View ticketHistory = vi.inflate(R.layout.ticket_history_element_small, insertPointOne);
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(tickets.get(row).getExpirationDate(), df);
            ticketHistory.setId(row);
            LinearLayout ticketHistoryField = ticketHistory.findViewById(R.id.ticket_history_element_small);

            TextView ticketElementLineNumber = ticketHistory.findViewById(R.id.ticket_history_element_line_number);
            String valueOfBusStop = String.valueOf(tickets.get(row).getLine());
            if (tickets.get(row).getLine() == 0) {
                ticketElementLineNumber.setText("Data wygaśniecia: " + tickets.get(row).getExpirationDate().substring(0, 16));
            }
            else {
                valueOfBusStop = "Numer Lini: " + valueOfBusStop;
                ticketElementLineNumber.setText(valueOfBusStop);
            }
            if (dateTime.isBefore(LocalDateTime.now())) {
                ticketHistoryField.setBackgroundColor(Color.parseColor("#80cccccc"));
            }
            else {
                ticketHistoryField.setBackgroundColor(Color.parseColor("#80ffffff"));
            }
            TextView ticketElementDate = ticketHistory.findViewById(R.id.ticket_history_element_date);
            ticketElementDate.setText("Data zakupu: " + tickets.get(row).getCreationDate().substring(0, 10));
            ticketHistory.setOnClickListener(v -> {
                Intent intent = new Intent(TicketHistoryActivity.this, TicketHistoryDetailsActivity.class);
                intent.putExtra("ticketType", tickets.get(v.getId()).getTicketType());
                intent.putExtra("ticketLine", tickets.get(v.getId()).getLine());
                intent.putExtra("count", tickets.get(v.getId()).getCount());
                intent.putExtra("price", tickets.get(v.getId()).getPrice());
                intent.putExtra("ticketExpirationDate", tickets.get(v.getId()).getExpirationDate());
                intent.putExtra("ticketCreationDate", tickets.get(v.getId()).getCreationDate());
                startActivity(intent);
            });
            }
                Button previousActivity = header.findViewById(R.id.previous);
                previousActivity.setOnClickListener(view -> {
                    // Finish the current activity and return to the previous one
                    finish();
                });
            }
        }