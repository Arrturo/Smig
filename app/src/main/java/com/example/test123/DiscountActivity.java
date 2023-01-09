package com.example.test123;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DiscountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DELETE HEADER
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.client_add_discount);

        DBHandler dbHandler = new DBHandler(DiscountActivity.this);

        //SPINNER
        Spinner discounts = findViewById(R.id.discount_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.discounts,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discounts.setAdapter(adapter);
        discounts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button send_discounts = findViewById(R.id.send_discount);
        send_discounts.setOnClickListener(view -> {
            switch (discounts.getSelectedItemPosition()) {
                case 0:
                    dbHandler.addDiscount(30);
                    break;
                case 1:
                    dbHandler.addDiscount(70);
                    break;
                case 2:
                    dbHandler.addDiscount(95);
                    break;
                case 3:
                    dbHandler.addDiscount(37);
                    break;
                case 4:
                    dbHandler.addDiscount(100);
                    break;
            }
            finish();
        });

        //PREVIOUS ACTIVITY BUTTON
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });

    }
}
