package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

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
        TextView line_number_date = contentView.findViewById(R.id.line_number_date);
        TextView ticketDate = contentView.findViewById(R.id.ticket_history_element_date);
        TextView count = contentView.findViewById(R.id.count);
        if (getIntent().getIntExtra("ticketLine", 0) == 0){
            line_number_date.setText("Data wygaśnięcia:");
            ticketNumber.setText(getIntent().getStringExtra("ticketExpirationDate"));
        }
        else{
            line_number_date.setText("Numer linii:");
            ticketNumber.setText(String.valueOf(getIntent().getIntExtra("ticketLine", 0)));
        }
        ticketType.setText(getIntent().getStringExtra("ticketType"));
        ticketDate.setText(getIntent().getStringExtra("ticketCreationDate"));
        count.setText(String.valueOf(getIntent().getIntExtra("count", 0)));

        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


