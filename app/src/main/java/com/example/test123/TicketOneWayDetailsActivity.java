package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class TicketOneWayDetailsActivity extends AppCompatActivity {
    TextView ticketType;
    TextView ticketPrice;
    TextView TicketLine;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        float price = (float) getIntent().getDoubleExtra("price", 0);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_one_way_details);
        TextView header_title = findViewById(R.id.header_title);
        header_title.setText("Kup bilet");
        ticketType = findViewById(R.id.ticket_type);
        TicketLine = findViewById(R.id.ticket_line_number);
        ticketPrice = findViewById(R.id.ticket_price);
        ticketType.setText(getIntent().getStringExtra("ticketType"));
        ticketPrice.setText(String.format("%.2f", price) + " zł");
        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
        TextWatcher cWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    ticketPrice.setText(String.format("%.2f", price) + " zł");
                } else {
                    ticketPrice.setText(String.format("%.2f", price * Double.parseDouble(s.toString())) + " zł");
                }
            }
        };
        TextView count = findViewById(R.id.Tickets_amount);
        count.addTextChangedListener(cWatcher);
        Button buy = findViewById(R.id.buy_ticket_button);
        buy.setOnClickListener(v -> {
            DBHandler db = new DBHandler(this);
            if (count.getText().toString().equals("") || Integer.parseInt(count.getText().toString()) == 0){
                Toast.makeText(this, "Podaj ilość biletów", Toast.LENGTH_SHORT).show();
            }
            else if (TicketLine.getText().toString().equals("") || Integer.parseInt(TicketLine.getText().toString()) == 0){
                Toast.makeText(this, "Podaj numer linii", Toast.LENGTH_SHORT).show();
            }
            else {
                db.buyTicket(getIntent().getStringExtra("ticketType"), price * Integer.parseInt(count.getText().toString()), Integer.parseInt(count.getText().toString()), Integer.parseInt(TicketLine.getText().toString()), getIntent().getIntExtra("time", 0));
                Toast.makeText(this, "Bilet został zakupiony", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
