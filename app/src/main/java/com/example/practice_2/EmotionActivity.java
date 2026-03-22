package com.example.practice_2;

import android.os.Bundle;

import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EmotionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ScrollView scrollView = new ScrollView(this);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#FFF0F5"));

        TextView nameText = new TextView(this);
        String userName = getIntent().getStringExtra("USER_NAME");
        nameText.setText("Пользователь: " + (userName == null || userName.isEmpty() ? "Гость" : userName));
        nameText.setTextSize(18);
        int nameTextId = TextView.generateViewId();
        nameText.setId(nameTextId);

        User user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        nameText.setText("Email: " + (user != null ? user.getEmail() : "---"));

        RelativeLayout.LayoutParams nameParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameParams.setMargins(50, 80, 50, 0);
        nameText.setLayoutParams(nameParams);
        relativeLayout.addView(nameText);

        EditText emotionInput = new EditText(this);

        emotionInput.setHint(R.string.hint_emotion_desc);
        int emotionInputId = EditText.generateViewId();
        emotionInput.setId(emotionInputId);

        RelativeLayout.LayoutParams inputParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        inputParams.addRule(RelativeLayout.BELOW, nameTextId);
        inputParams.setMargins(50, 40, 50, 0);
        emotionInput.setLayoutParams(inputParams);
        relativeLayout.addView(emotionInput);

        Button saveBtn = new Button(this);
        saveBtn.setText(R.string.save_state);
        saveBtn.setBackgroundColor(Color.parseColor("#F48FB1"));
        saveBtn.setTextColor(Color.WHITE);

        saveBtn.setOnClickListener(v -> finish());

        RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnParams.addRule(RelativeLayout.BELOW, emotionInputId);
        btnParams.setMargins(50, 40, 50, 0);
        saveBtn.setLayoutParams(btnParams);
        relativeLayout.addView(saveBtn);

        scrollView.addView(relativeLayout);
        setContentView(scrollView);
    }
}