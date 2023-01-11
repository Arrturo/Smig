package com.example.test123;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimetableActivity extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // delete header
        if (getSupportActionBar() != null) getSupportActionBar().hide();
            setContentView(R.layout.timetable_menu);
            
// insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.timetable_menu);
        for(int row = 0; row < 12; row++){
            if(row % 2 == 0){
                LayoutInflater vi = getLayoutInflater();
                View pair = vi.inflate(R.layout.timetable_menu_elements_pair, insertPoint);
                pair.setId(row);
                ViewGroup insertPointOne = (ViewGroup) findViewById(R.id.timetable_menu_elements_pair);
                for(int column = 0; column <= 1; column++){
                    if(column == 0) {
                        View btn = vi.inflate(R.layout.timetable_menu_elements_pair_btn2, insertPointOne);
                        btn.setId(row+column);
                        int eq = row+column;
                        String s = String.valueOf(eq);
                        int itemek = btn.getId();
                        Button b = btn.findViewById(R.id.timetable_menu_elements_btn2);
                        b.setText(s);
                    }else{
                        View btn2 = vi.inflate(R.layout.timetable_menu_elements_pair_btn, insertPointOne);
                        Button b2 = btn2.findViewById(R.id.timetable_menu_elements_btn);
                        b2.setText("233");
                        btn2.setId(row+column);
                    }

                }
            }
        }

        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}