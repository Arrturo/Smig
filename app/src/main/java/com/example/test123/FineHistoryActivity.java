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

import com.example.test123.R;
import com.example.test123.TicketHistoryActivity;
import com.example.test123.TicketHistoryDetailsActivity;

public class FineHistoryActivity extends AppCompatActivity{
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
        headerText.setText("Historia Mandatów");


        for (int row = 0; row < 12; row++) {
            if (row % 2 == 0) {
                View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
                View fineHistory = vi.inflate(R.layout.fine_history_element_small, insertPointOne);
                fineHistory.setId(row);
                TextView fineElementDate = fineHistory.findViewById(R.id.fine_element_date);
                fineElementDate.setText("28.01.2022"); // Zamiast ValueOfId numer lini w stringu
                fineHistory.setOnClickListener(v -> {
                    Intent intent = new Intent(FineHistoryActivity.this, FineHistoryDetailsActivity.class);
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


