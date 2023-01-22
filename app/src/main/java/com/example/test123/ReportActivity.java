package com.example.test123;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.send_report);
        DBHandler db = new DBHandler(this);
        TextView header = findViewById(R.id.header_title);
        header.setText("Zgłoś problem");
        Spinner reports = findViewById(R.id.report_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.reports_types,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reports.setAdapter(adapter);
        reports.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button sendReport = findViewById(R.id.send_report);
        sendReport.setOnClickListener(view -> {
            TextView textView = (TextView) findViewById(R.id.message);
            String topic = reports.getSelectedItem().toString();
            String message = textView.getText().toString();
            db.sendReport(topic, message);
            Toast.makeText(ReportActivity.this, "Zgłoszenie zostało wysłane", Toast.LENGTH_SHORT).show();
            finish();
        });

        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });
    }
}
