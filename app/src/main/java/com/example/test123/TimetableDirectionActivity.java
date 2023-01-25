package com.example.test123;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;


public class TimetableDirectionActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHandler db = new DBHandler(this);
        /*not quite good solution, but it works
        will be changed in the future*/
        Integer id = db.getCurrentId(getIntent().getStringExtra("busNumber"));
        ArrayList<String> route = db.getAllRoutes(id);
        ArrayList<String> stops = db.getAllStop(id);
        AtomicBoolean dir = new AtomicBoolean(false);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);

        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Rozkład Jazdy");
        View directionsView = vi.inflate(R.layout.timetable_direction, insertPoint);

        Button btnTop = directionsView.findViewById(R.id.timetable_direction_element_btn_top);
        btnTop.setText(route.get(0) + " -> " + route.get(route.size()-1));
        btnTop.setOnClickListener(v -> {
            if(dir.get()){
                Collections.reverse(route);
                Collections.reverse(stops);
                dir.set(false);
            }
            Intent intent = new Intent(TimetableDirectionActivity.this, TimetableTimesMenuActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("route", route);
            intent.putExtra("stop", stops);
            startActivity(intent);
        });

        Button btnBottom = directionsView.findViewById(R.id.timetable_direction_element_btn_bottom);
        btnBottom.setText(route.get(route.size() - 1 ) + " -> " + route.get(0));
        btnBottom.setOnClickListener(v -> {
            Intent intent = new Intent(TimetableDirectionActivity.this, TimetableTimesMenuActivity.class);
            if(!dir.get()){
                Collections.reverse(route);
                Collections.reverse(stops);
                dir.set(true);
            }
            intent.putExtra("id", id);
            intent.putExtra("route", route);
            intent.putExtra("stop", stops);
            startActivity(intent);
        });

        Button previousActivity = header.findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}