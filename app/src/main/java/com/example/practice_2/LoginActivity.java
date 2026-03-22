package com.example.practice_2;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            User user = new User(nameInput.getText().toString(), emailInput.getText().toString());
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("USER_OBJECT", user); // Передача сложного объекта
            startActivity(intent);
        });
    }
}