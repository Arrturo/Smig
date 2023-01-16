package com.example.test123;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinePayDetailsActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Zaległe mandaty");
        View contentView = vi.inflate(R.layout.fine_pay, insertPoint);

        TextView fineDate = contentView.findViewById(R.id.fine_pay_date);
        TextView fineValue = contentView.findViewById(R.id.fine_pay_value);
        TextView fineKontrolerID = contentView.findViewById(R.id.fine_pay_kontrolerID);
        TextView fineReason = contentView.findViewById(R.id.fine_pay_reason);

        fineDate.setText("28.10.2022");
        String value = "Kwota: "+"120 "+"zł";
        fineValue.setText(value);
        String kontrolerID = "ID Kontrolera: "+"2463";
        fineKontrolerID.setText(kontrolerID);
        String reason = "Powód: "+"Brak biletu";
        fineReason.setText(reason);

        Button buttonPay = contentView.findViewById(R.id.fine_pay_button);

        buttonPay.setOnClickListener(v -> {
            Intent intent = new Intent(FinePayDetailsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button previous = header.findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


