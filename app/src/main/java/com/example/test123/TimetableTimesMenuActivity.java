package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TimetableTimesMenuActivity extends AppCompatActivity {
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
        setContentView(R.layout.timetable_times_menu);


//        Button Profile = (Button) findViewById(R.id.Client_profile);
//        Button SendReport = (Button) findViewById(R.id.Create_report);
        Button Ticket_oneway = findViewById(R.id.line_time_1);
        Ticket_oneway.setOnClickListener(v -> {
            Intent intent = new Intent(TimetableTimesMenuActivity.this, TimetableDetailsActivity.class);
            startActivity(intent);
        });
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}