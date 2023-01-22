package com.example.test123;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBHandler dbHandler = new DBHandler(this);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.login);
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button login = findViewById(R.id.logowanie);

        login.setOnClickListener(v -> {
            if (dbHandler.Login(username.getText().toString(), password.getText().toString())) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                username.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(), "Niepoprawne dane logowania", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
