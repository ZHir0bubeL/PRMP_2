package com.example.practice_2;

import android.os.Bundle;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        User user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.welcome, user.getName()));

        findViewById(R.id.btnNew).setOnClickListener(v -> {
            Intent intent = new Intent(this, EmotionActivity.class);
            intent.putExtra("USER_OBJECT", user);
            startActivity(intent);
        });

        findViewById(R.id.btnGuide).setOnClickListener(v ->
                startActivity(new Intent(this, GuideActivity.class)));
    }
}