package com.example.test123;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalTime;
import java.util.ArrayList;


public class TimetableDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHandler db = new DBHandler(this);
        Integer id = getIntent().getIntExtra("id", 0);
        ArrayList<String> route = getIntent().getStringArrayListExtra("route");
        String time = getIntent().getStringExtra("time");
        ArrayList<String> stops = getIntent().getStringArrayListExtra("stops");
        ArrayList<LocalTime> departues = new ArrayList<>();
        departues.add(LocalTime.parse(time));

        for (int row = 0; row < stops.size(); row++) {
                LocalTime temp = departues.get(row);
                departues.add(temp.plusMinutes(Integer.parseInt(stops.get(row))));
        }

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Rozkład Jazdy");

        View lineNumberView = vi.inflate(R.layout.timetable_line_element_number, insertPoint);
        TextView lineNumber = lineNumberView.findViewById(R.id.timetable_line_element_number);
        lineNumber.setText(db.getAllBusNumbers().get(id - 1));

        View lineDirectionView = vi.inflate(R.layout.timetable_line_element_direction, insertPoint);
        TextView lineDirection = lineDirectionView.findViewById(R.id.timetable_element_direction);
        lineDirection.setText(route.get(route.size()-1));


        View startLocationView = vi.inflate(R.layout.timetable_line_element_start, insertPoint);
        TextView startLocation = startLocationView.findViewById(R.id.timetable_start_element_name);
        startLocation.setText(route.get(0));
        TextView startTime = startLocationView.findViewById(R.id.timetable_start_element_time);
        startTime.setText(departues.get(0).toString());

        for (int row = 1; row < route.size() - 1; row++) {
                View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
                View midLocationView = vi.inflate(R.layout.timetable_line_element_mid, insertPointOne);
                midLocationView.setId(row);
                TextView midLocation = midLocationView.findViewById(R.id.timetable_mid_element_name);
                midLocation.setText(route.get(row));
                TextView midTime = midLocationView.findViewById(R.id.timetable_mid_element_time);
                midTime.setText(departues.get(row).toString());
            }

            View endLocationView = vi.inflate(R.layout.timetable_line_element_end, insertPoint);
            TextView endLocation = endLocationView.findViewById(R.id.timetable_end_element_name);
            endLocation.setText(route.get(route.size()-1));
            TextView endTime = endLocationView.findViewById(R.id.timetable_end_element_time);
            endTime.setText(departues.get(departues.size()-1).toString());


            Button previousActivity = header.findViewById(R.id.previous);
            previousActivity.setOnClickListener(view -> {
                // Finish the current activity and return to the previous one
                finish();
            });
    }
}
