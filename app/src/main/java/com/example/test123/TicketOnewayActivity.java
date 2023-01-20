package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TicketOnewayActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        DBHandler db = new DBHandler(this);
        double discount = 1 - db.getDiscount() / 100.0;

        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.ticket_one_way);
        TextView header_title = findViewById(R.id.header_title);
        header_title.setText("Kup bilet");

        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);

        LayoutInflater vi = getLayoutInflater();
        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Kup bilet");

        DBHandler dbHandler = new DBHandler(TicketOnewayActivity.this);

        ArrayList<TicketInOffer> tickets = dbHandler.TicketsOffer(0, 3600);
        for (int row = 0; row < tickets.size(); row++) {

            View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
            pair.setId(row);
            ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
            View TicketOffer = vi.inflate(R.layout.choose_ticket_btn, insertPointOne);
            TicketOffer.setId(row);
            TextView ticketName = TicketOffer.findViewById(R.id.ticket_type);

            ticketName.setText(tickets.get(row).getType());
            TicketOffer.setOnClickListener(v -> {
                if (tickets.get(v.getId()).getTime() == 3000){
                    Intent intent = new Intent(TicketOnewayActivity.this,TicketOneWayDetailsActivity.class);
                    intent.putExtra("ticketType", tickets.get(v.getId()).getType());
                    intent.putExtra("price", tickets.get(v.getId()).getPrice() * 1.0);
                    intent.putExtra("time", tickets.get(v.getId()).getTime());
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(TicketOnewayActivity.this,TicketDetailsActivity.class);
                    intent.putExtra("ticketType", tickets.get(v.getId()).getType());
                    intent.putExtra("price", tickets.get(v.getId()).getPrice() * discount);
                    intent.putExtra("time", tickets.get(v.getId()).getTime());
                    startActivity(intent);
                }
            });
            View pairReduced = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
            pairReduced.setId(row);
            @SuppressLint("CutPasteId") ViewGroup insertPointOneReduced = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
            View TicketOfferReduced = vi.inflate(R.layout.choose_ticket_btn, insertPointOneReduced);
            TicketOfferReduced.setId(row);
            TextView ticketNameReduced = TicketOfferReduced.findViewById(R.id.ticket_type);
            ticketNameReduced.setText(tickets.get(row).getType() + " Ulgowy");
            TicketOfferReduced.setOnClickListener(v -> {
                if (tickets.get(v.getId()).getTime() == 3000){
                    Intent intentReduced = new Intent(TicketOnewayActivity.this, TicketOneWayDetailsActivity.class);
                    intentReduced.putExtra("ticketType", tickets.get(v.getId()).getType() + " ulgowy");
                    intentReduced.putExtra("price", tickets.get(v.getId()).getPrice() * discount);
                    intentReduced.putExtra("time", tickets.get(v.getId()).getTime());
                    startActivity(intentReduced);
                }
                else {
                    Intent intentReduced = new Intent(TicketOnewayActivity.this, TicketDetailsActivity.class);
                    intentReduced.putExtra("ticketType", tickets.get(v.getId()).getType() + " ulgowy");
                    intentReduced.putExtra("price", tickets.get(v.getId()).getPrice() * discount);
                    intentReduced.putExtra("time", tickets.get(v.getId()).getTime());
                    startActivity(intentReduced);
                }
            });
        }

        Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(view -> finish());
    }
}


