package com.example.practice_2;

import android.os.Bundle;

import android.graphics.Color;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#FFF0F5"));

        TextView welcomeText = new TextView(this);
        String userName = getIntent().getStringExtra("USER_NAME");
        welcomeText.setTextSize(24);
        int textId = TextView.generateViewId();
        welcomeText.setId(textId);

        User user = (User) getIntent().getSerializableExtra("USER_OBJECT");
        String nickname = (user != null) ? user.getName() : "Guest";
        welcomeText.setText(getString(R.string.welcome, nickname));


        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 100, 0, 0);
        welcomeText.setLayoutParams(textParams);
        relativeLayout.addView(welcomeText);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(1);
        gridLayout.setColumnCount(2);

        RelativeLayout.LayoutParams gridParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        gridParams.addRule(RelativeLayout.BELOW, textId);
        gridParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        gridParams.setMargins(0, 100, 0, 0);
        gridLayout.setLayoutParams(gridParams);

        Button btnNew = new Button(this);
        btnNew.setText(R.string.btn_new_emotion);
        btnNew.setBackgroundColor(Color.parseColor("#F48FB1"));
        btnNew.setTextColor(Color.WHITE);
        GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
        params1.setMargins(0, 0, 40, 0);
        btnNew.setLayoutParams(params1);
        btnNew.setOnClickListener(v -> {
            Intent intent = new Intent(this, EmotionActivity.class);
            intent.putExtra("USER_OBJECT", user);
            startActivity(intent);
        });
        gridLayout.addView(btnNew);

        Button btnGuide = new Button(this);
        btnGuide.setText(R.string.btn_guide);
        btnGuide.setBackgroundColor(Color.parseColor("#F48FB1"));
        btnGuide.setTextColor(Color.WHITE);
        btnGuide.setOnClickListener(v -> startActivity(new Intent(this, GuideActivity.class)));
        gridLayout.addView(btnGuide);

        relativeLayout.addView(gridLayout);
        setContentView(relativeLayout);
    }
}