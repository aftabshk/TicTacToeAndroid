package com.example.androidbasics.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbasics.R;

public class LandingPageView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        Button start = findViewById(R.id.start_game);
        EditText player1Name = findViewById(R.id.player_1_name);
        EditText player2Name = findViewById(R.id.player_2_name);

        start.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, TicTacToeView.class);
            intent.putExtra("player1Name", player1Name.getText().toString());
            intent.putExtra("player2Name", player2Name.getText().toString());
            startActivity(intent);
        });
    }
}
