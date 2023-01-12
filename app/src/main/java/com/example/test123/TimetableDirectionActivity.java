package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TimetableDirectionActivity extends AppCompatActivity {
    private final String username = "Ewa";
    private final String email = "EwaStonoga@gmail.com";
    private final String phone = "123323789";
    private final String password = "123456789";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_direction);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.timetable_direction);

        LayoutInflater vi = getLayoutInflater();
        View directionsView = vi.inflate(R.layout.timetable_direction, insertPoint);

        Button btnTop = directionsView.findViewById(R.id.timetable_direction_element_btn_top);
        btnTop.setText("Pierwszy Kierunek");
        btnTop.setOnClickListener(v -> {
            Intent intent = new Intent(TimetableDirectionActivity.this, TimetableTimesMenuActivity.class);
            startActivity(intent);
        });

        Button btnBottom = directionsView.findViewById(R.id.timetable_direction_element_btn_bottom);
        btnBottom.setText("Drugi Kierunek");
        btnBottom.setOnClickListener(v -> {
            Intent intent = new Intent(TimetableDirectionActivity.this, TimetableTimesMenuActivity.class);
            startActivity(intent);
        });

        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}