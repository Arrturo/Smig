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

public class TimetableTimesMenuActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.timetable_menu_back);

        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content);
        LayoutInflater vi = getLayoutInflater();

        View header = vi.inflate(R.layout.header, insertPoint);
        TextView headerText = header.findViewById(R.id.header_title);
        headerText.setText("Rozkład Jazdy");

        for(int row = 0; row < 12; row++){
            if(row % 2 == 0){
                View pair = vi.inflate(R.layout.timetable_times_menu_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_times_menu_pair);
                for(int column = 0; column <= 1; column++){
                    if(column == 0) {
                        View btnLeftView = vi.inflate(R.layout.timetable_times_menu_pair_left, insertPointOne);
                        btnLeftView.setId(row+column);
                        Button btnLeft = btnLeftView.findViewById(R.id.timetable_times_menu_btn_left);
                        String valueOfId = String.valueOf(row+column);
                        btnLeft.setText(valueOfId); // Zamiast ValueOfId godzina odjazdu z petli autobusu w stringu
                        btnLeft.setOnClickListener(v -> {
                            Intent intent = new Intent(TimetableTimesMenuActivity.this, TimetableDetailsActivity.class);
                            startActivity(intent);
                        });

                    }else{
                        View btnRightView = vi.inflate(R.layout.timetable_times_menu_pair_right, insertPointOne);
                        Button btnRight = btnRightView.findViewById(R.id.timetable_times_menu_btn_right);
                        btnRight.setId(row+column);
                        String valueOfId = String.valueOf(row+column);
                        btnRight.setText(valueOfId); //Zamiast ValueOfId godzina odjazdu z petli autobusu w stringu
                        btnRight.setOnClickListener(v -> {
                            Intent intent = new Intent(TimetableTimesMenuActivity.this, TimetableDetailsActivity.class);
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