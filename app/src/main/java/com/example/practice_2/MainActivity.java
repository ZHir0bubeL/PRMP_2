package com.example.practice_2;

import android.os.Bundle;

import android.content.Intent;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = new FrameLayout(this);

        frameLayout.setBackgroundResource(R.drawable.background);

        Button startButton = new Button(this);
        startButton.setText("Перейти в приложение");
        startButton.setTextSize(20);
        startButton.setPadding(80, 40, 80, 40);
        startButton.setElevation(0);
        startButton.setBackgroundColor(android.graphics.Color.parseColor("#FAFAFA"));

        FrameLayout.LayoutParams buttonParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        buttonParams.gravity = Gravity.CENTER;

        startButton.setLayoutParams(buttonParams);
        frameLayout.addView(startButton);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        setContentView(frameLayout);
    }
}