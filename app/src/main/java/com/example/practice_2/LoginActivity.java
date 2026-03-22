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
        title.setText(R.string.login_title);
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 60);

        EditText emailInput = new EditText(this);
        emailInput.setHint(R.string.hint_email);

        EditText nameInput = new EditText(this);
        nameInput.setHint(R.string.hint_name);

        EditText passwordInput = new EditText(this);
        passwordInput.setHint(R.string.hint_pass);
        passwordInput.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);

        Button loginButton = new Button(this);
        loginButton.setText(R.string.btn_login);
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
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();

            User user = new User(name, email);

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            intent.putExtra("USER_OBJECT", user);
            startActivity(intent);
        });
        setContentView(linearLayout);
    }
}