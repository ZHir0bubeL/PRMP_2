package com.example.practice_2;

import android.os.Bundle;

import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackgroundColor(Color.parseColor("#FFF0F5"));
        linearLayout.setPadding(60, 0, 60, 0);

        TextView title = new TextView(this);
        title.setText("Вход в дневник");
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 60);

        EditText emailInput = new EditText(this);
        emailInput.setHint("Введите почту");

        EditText nameInput = new EditText(this);
        nameInput.setHint("Как к вам обращаться?");

        EditText passwordInput = new EditText(this);
        passwordInput.setHint("Пароль");
        passwordInput.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);

        Button loginButton = new Button(this);
        loginButton.setText("Войти");
        loginButton.setElevation(0);
        loginButton.setBackgroundColor(Color.parseColor("#F48FB1"));
        loginButton.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btnParams.setMargins(0, 50, 0, 0);
        loginButton.setLayoutParams(btnParams);

        linearLayout.addView(title);
        linearLayout.addView(emailInput);
        linearLayout.addView(nameInput);
        linearLayout.addView(passwordInput);
        linearLayout.addView(loginButton);

        loginButton.setOnClickListener(v -> {
            String userName = nameInput.getText().toString();

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            intent.putExtra("USER_NAME", userName);
            startActivity(intent);
        });

        setContentView(linearLayout);
    }
}