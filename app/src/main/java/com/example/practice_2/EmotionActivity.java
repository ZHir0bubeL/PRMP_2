package com.example.practice_2;

import android.os.Bundle;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmotionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);

        User user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        TextView info = findViewById(R.id.userInfoText);
        info.setText("User: " + user.getName() + " (" + user.getEmail() + ")");

        findViewById(R.id.saveBtn).setOnClickListener(v -> finish()); // Возврат назад
    }
}