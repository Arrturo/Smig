package com.example.test123;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClientProfile extends AppCompatActivity {
    TextView username;
    TextView email;
    TextView phone;
    TextView password;
    private DBHandler dbHandler;

    @SuppressLint("SetTextI18n")
    public void GetDataToTextView() {
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        username.setText(getIntent().getStringExtra("username"));
        email.setText(getIntent().getStringExtra("email"));
        phone.setText(getIntent().getStringExtra("phone"));
        password.setText(getIntent().getStringExtra("password"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.client_profile);
        GetDataToTextView();
        Button previousActivity = findViewById(R.id.previous);
        previousActivity.setOnClickListener(view -> {
            // Finish the current activity and return to the previous one
            finish();
        });

        Button addDiscount = findViewById(R.id.add_discount);
        addDiscount.setOnClickListener(v -> {
            Intent intent = new Intent(ClientProfile.this, DiscountActivity.class);
            startActivity(intent);
        });

        Button edit_profile = findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(v -> {
                // below line is to get data from all edit text fields.
                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();
                String Password = password.getText().toString();

                // validating if the text fields are empty or not.
                if (Username.isEmpty() && Email.isEmpty() && Phone.isEmpty() && Password.isEmpty()) {
                    Toast.makeText(ClientProfile.this, "Uzupełnij wszystkie pola!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(Username, Email, Phone, Password);

                // after adding the data we are displaying a toast message.
                Toast.makeText(ClientProfile.this, "Edytowane!", Toast.LENGTH_SHORT).show();

        });
    }

}
