package com.example.androidbasics.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbasics.R;

public class LandingPageView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button start = findViewById(R.id.start_game);

        start.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, TicTacToeView.class);
            startActivity(intent);
        });
    }
}
