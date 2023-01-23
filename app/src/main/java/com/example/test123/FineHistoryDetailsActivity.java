package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FineHistoryDetailsActivity extends AppCompatActivity {
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Szczegóły mandatu");
        View contentView = vi.inflate(R.layout.fine_history_element_big, insertPoint);

        TextView fineDate = contentView.findViewById(R.id.fine_element_date);
        TextView fineValue = contentView.findViewById(R.id.fine_element_value);
        TextView fineKontrolerID = contentView.findViewById(R.id.fine_element_kontroler_id);
        TextView fineReason = contentView.findViewById(R.id.fine_element_reason);

        fineDate.setText(getIntent().getStringExtra("date").substring(0, 16));
        fineValue.setText(String.format("%.2f", getIntent().getFloatExtra("amount", 0)) + " zł");
        fineKontrolerID.setText("ID Kontrolera: "+ getIntent().getIntExtra("workerID", 0));
        fineReason.setText("Powód: " + getIntent().getStringExtra("reason"));

        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


