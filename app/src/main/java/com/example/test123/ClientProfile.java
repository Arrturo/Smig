package com.example.test123;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientProfile extends AppCompatActivity {
    TextView usernameTV, emailTV, phoneTV, passwordTV;
    DBHandler dbHandler;

    @SuppressLint("SetTextI18n")
    public void GetDataToTextView() {
        usernameTV = findViewById(R.id.username);
        emailTV = findViewById(R.id.email);
        phoneTV = findViewById(R.id.phone);
        passwordTV = findViewById(R.id.password);

        usernameTV.setText(getIntent().getStringExtra("username"));
        emailTV.setText(getIntent().getStringExtra("email"));
        phoneTV.setText(getIntent().getStringExtra("phone"));
        passwordTV.setText(getIntent().getStringExtra("password"));
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.client_profile);
        Button addDiscount = findViewById(R.id.add_discount);
        GetDataToTextView();

        if (getIntent().getIntExtra("discount", 0) != 0) {
            addDiscount.setEnabled(false);
            TextView discountTV = findViewById(R.id.add_discount_string);
            discountTV.setText("Masz już zniżkę!");
            discountTV.setTextColor(Color.parseColor("#1FFF27"));
        }
        System.out.println(getIntent().getIntExtra("discount", 0));
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });

        dbHandler = new DBHandler(ClientProfile.this);
        addDiscount.setOnClickListener(v -> {
            Intent intent = new Intent(ClientProfile.this, DiscountActivity.class);
            startActivity(intent);
        });

        Button edit_profile = findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(v -> {
            // below line is to get data from all edit text fields.
            String Username = usernameTV.getText().toString();
            String Email = emailTV.getText().toString();
            String Phone = phoneTV.getText().toString();
            String Password = passwordTV.getText().toString();

            // validating if the text fields are empty or not.
            if (Username.isEmpty() || Email.isEmpty() || Phone.isEmpty() || Password.isEmpty() || Password.length() < 8 || Phone.length() != 9) {
                Toast.makeText(ClientProfile.this, "Niepoprawne uzupełnione dane!!", Toast.LENGTH_SHORT).show();
                return;
            }

            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            dbHandler.updateUser(Username, Email, Phone, Password);

            // after adding the data we are displaying a toast message.
            Toast.makeText(ClientProfile.this, "Edytowane!", Toast.LENGTH_SHORT).show();
            finish();

        });
    }
}