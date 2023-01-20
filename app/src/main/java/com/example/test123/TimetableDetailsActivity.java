package com.example.test123;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TimetableDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHandler db = new DBHandler(this);
        Integer id = getIntent().getIntExtra("id", 0);
        ArrayList<String> route = getIntent().getStringArrayListExtra("route");

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
        lineNumber.setText(db.getAllBusNumbers().get(id - 1)); // Zamiast wartości prawdziwy numer lini w stringu

        View lineDirectionView = vi.inflate(R.layout.timetable_line_element_direction, insertPoint);
        TextView lineDirection = lineDirectionView.findViewById(R.id.timetable_element_direction);
//        lineDirection.setText(db.getAllRoutes(id).get(db.getAllRoutes(id).size()-1)); // Zamiast wartości prawdziwy cel w stringu
        lineDirection.setText(route.get(route.size()-1));


        View startLocationView = vi.inflate(R.layout.timetable_line_element_start, insertPoint);
        TextView startLocation = startLocationView.findViewById(R.id.timetable_start_element_name);
//        startLocation.setText(db.getAllRoutes(id).get(0));
        startLocation.setText(route.get(0));
        TextView startTime = startLocationView.findViewById(R.id.timetable_start_element_time);
        startTime.setText(db.getAllTime(id).get(0));

//        for (int row = 0; row < db.getAllRoutes(id).size() - 2; row++) {
        for (int row = 0; row < route.size() - 2; row++) {
                View pair = vi.inflate(R.layout.timetable_line_detail_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_line_detail_pair);
                View midLocationView = vi.inflate(R.layout.timetable_line_element_mid, insertPointOne);
                midLocationView.setId(row);
                TextView midLocation = midLocationView.findViewById(R.id.timetable_mid_element_name);
//                String valueOfBusStop = String.valueOf(row);
//                valueOfBusStop = "Przystanek numer" + valueOfBusStop;
//                midLocation.setText(db.getAllRoutes(id).get(row + 1)); // Zamiast ValueOfId nazwa przystanku w stringu
                midLocation.setText(route.get(row + 1));
                TextView midTime = midLocationView.findViewById(R.id.timetable_mid_element_time);
                midTime.setText(db.getAllTime(id).get(row + 1)); // Zamiast ValueOfId godzina odjazdu z przystanku autobusu w stringu
            }


            View endLocationView = vi.inflate(R.layout.timetable_line_element_end, insertPoint);
            TextView endLocation = endLocationView.findViewById(R.id.timetable_end_element_name);
//            endLocation.setText(db.getAllRoutes(id).get(db.getAllRoutes(id).size()-1));
            endLocation.setText(route.get(route.size()-1));
            TextView endTime = endLocationView.findViewById(R.id.timetable_end_element_time);
            endTime.setText(db.getAllTime(id).get(db.getAllTime(id).size()-1));


            Button previousActivity = header.findViewById(R.id.previous);
            previousActivity.setOnClickListener(view -> {
                // Finish the current activity and return to the previous one
                finish();
            });
    }
}
