package com.example.test123;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimetableDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_line_detail);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View lineNumberView = vi.inflate(R.layout.timetable_line_element_number, insertPoint);
        TextView lineNumber = lineNumberView.findViewById(R.id.timetable_line_element_number);
        lineNumber.setText("103"); // Zamiast wartości prawdziwy numer lini w stringu

        View lineDirectionView = vi.inflate(R.layout.timetable_line_element_direction, insertPoint);
        TextView lineDirection = lineDirectionView.findViewById(R.id.timetable_element_direction);
        lineDirection.setText("Kierunek: WMII na UWM"); // Zamiast wartości prawdziwy cel w stringu


        View startLocationView = vi.inflate(R.layout.timetable_line_element_start, insertPoint);
        TextView startLocation = startLocationView.findViewById(R.id.timetable_start_element_name);
        startLocation.setText("Dworzec PKP");
        TextView startTime = startLocationView.findViewById(R.id.timetable_start_element_time);
        startTime.setText("04:20");

        for (int row = 0; row < 12; row++) {
            if (row % 2 == 0) {
                View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
                View midLocationView = vi.inflate(R.layout.timetable_line_element_mid, insertPointOne);
                midLocationView.setId(row);
                TextView midLocation = midLocationView.findViewById(R.id.timetable_mid_element_name);
                String valueOfBusStop = String.valueOf(row);
                valueOfBusStop = "Przystanek numer" + valueOfBusStop;
                midLocation.setText(valueOfBusStop); // Zamiast ValueOfId nazwa przystanku w stringu
                TextView midTime = midLocationView.findViewById(R.id.timetable_mid_element_time);
                midTime.setText("04:20"); // Zamiast ValueOfId godzina odjazdu z przystanku autobusu w stringu
                }
            }


            View endLocationView = vi.inflate(R.layout.timetable_line_element_end, insertPoint);
            TextView endLocation = endLocationView.findViewById(R.id.timetable_end_element_name);
            endLocation.setText("Wydział matematki i informatyki");
            TextView endTime = endLocationView.findViewById(R.id.timetable_end_element_time);
            endTime.setText("05:27");


            Button previousActivity = findViewById(R.id.previous);
            previousActivity.setOnClickListener(view -> {
                // Finish the current activity and return to the previous one
                finish();
            });
    }
}
