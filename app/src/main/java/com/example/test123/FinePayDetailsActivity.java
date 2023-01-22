package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FinePayDetailsActivity extends AppCompatActivity {
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    protected void onCreate(Bundle savedInstanceState) {
        DBHandler dbHandler = new DBHandler(this);
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Zaległe mandaty");

        ArrayList<Mandate> mandates = dbHandler.getUnpaidMandates();
        for (int row = 0; row < mandates.size(); row++) {
            View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
            pair.setId(row);
            ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
            View fineHistory = vi.inflate(R.layout.fine_pay, insertPointOne);
            fineHistory.setId(row);
            TextView fineDate = fineHistory.findViewById(R.id.fine_pay_date);
            TextView fineValue = fineHistory.findViewById(R.id.fine_pay_value);
            TextView fineKontrolerID = fineHistory.findViewById(R.id.fine_pay_kontrolerID);
            TextView fineReason = fineHistory.findViewById(R.id.fine_pay_reason);
            fineDate.setText(mandates.get(row).getDate().substring(0, 16));
            fineValue.setText("Kwota: " + String.format("%.2f", mandates.get(row).getAmount()) + " zł");
            fineKontrolerID.setText("ID Kontrolera: " + mandates.get(row).getWorkerId());
            fineReason.setText("Powód: " + mandates.get(row).getReason());
            Button pay = fineHistory.findViewById(R.id.fine_pay_button);
            pay.setId(row);
            System.out.println(mandates.get(row).getID());
            pay.setOnClickListener(v -> {
                Intent intent = new Intent(FinePayDetailsActivity.this, MainActivity.class);
                dbHandler.payMandate(mandates.get(v.getId()).getID());
                Toast.makeText(FinePayDetailsActivity.this, "Zapłacono mandat wystawiony dnia: " + mandates.get(v.getId()).getDate().toString().substring(0, 10), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            });
        }

        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


