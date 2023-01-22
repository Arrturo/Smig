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
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test123.R;
import com.example.test123.TicketHistoryActivity;
import com.example.test123.TicketHistoryDetailsActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FineHistoryActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHandler dbHandler = new DBHandler(this);
        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);

        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Historia Mandatów");

        ArrayList<Mandate> mandates = dbHandler.getPaidMandates();
        for (int row = 0; row < mandates.size(); row++) {
            View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
            pair.setId(row);
            ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
            View fineHistory = vi.inflate(R.layout.fine_history_element_small, insertPointOne);
            fineHistory.setId(row);
            System.out.println(mandates.get(row).getWorkerId());
            TextView fineElementDate = fineHistory.findViewById(R.id.fine_element_date);
            fineElementDate.setText(mandates.get(row).getDate().substring(0, 16));
            fineHistory.setOnClickListener(v -> {
                Intent intent = new Intent(FineHistoryActivity.this, FineHistoryDetailsActivity.class);
                intent.putExtra("date", mandates.get(v.getId()).getDate());
                intent.putExtra("amount", mandates.get(v.getId()).getAmount());
                intent.putExtra("reason", mandates.get(v.getId()).getReason());
                intent.putExtra("workerID", mandates.get(v.getId()).getWorkerId());
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


