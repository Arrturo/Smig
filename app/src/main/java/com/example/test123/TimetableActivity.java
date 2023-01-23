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


public class TimetableActivity extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHandler db = new DBHandler(this);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

            ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
            LayoutInflater vi = getLayoutInflater();

            View header = vi.inflate(R.layout.header, insertPoint);
            TextView headerText = header.findViewById(R.id.header_title);
            headerText.setText("Rozkład Jazdy");

            for(int row = 0; row < db.getAllBusNumbers().size()-1; row++){
                if(row % 2 == 0) {
                    View pair = vi.inflate(R.layout.timetable_menu_elements_pair, insertPoint);
                    pair.setId(row);
                    ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_menu_elements_pair);
                    for (int column = 0; column <= 1; column++) {
                        if (column == 0) {
                            View btnLeftView = vi.inflate(R.layout.timetable_menu_elements_pair_left, insertPointOne);
                            btnLeftView.setId(row + column);
                            Button btnLeft = btnLeftView.findViewById(R.id.timetable_menu_elements_left);
                            btnLeft.setText(db.getAllBusNumbers().get(row + column));
                            btnLeft.setOnClickListener(v -> {
                                Intent intent = new Intent(TimetableActivity.this, TimetableDirectionActivity.class);
                                intent.putExtra("busNumber", btnLeft.getText().toString());
                                startActivity(intent);
                            });

                        } else {
                            View btnRightView = vi.inflate(R.layout.timetable_menu_elements_pair_right, insertPointOne);
                            Button btnRight = btnRightView.findViewById(R.id.timetable_menu_elements_right);
                            btnRight.setId(row + column);
                            btnRight.setText(db.getAllBusNumbers().get(row + column));
                            btnRight.setOnClickListener(v -> {
                                Intent intent = new Intent(TimetableActivity.this, TimetableDirectionActivity.class);
                                intent.putExtra("busNumber", btnRight.getText().toString());
                                startActivity(intent);
                            });
                        }

                    }
                }
            }

        Button previousActivity = header.findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}