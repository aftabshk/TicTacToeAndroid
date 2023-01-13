package com.example.androidbasics;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbasics.domain.TicTacToe;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TicTacToeView extends AppCompatActivity {

    private final TicTacToe ticTacToe = new TicTacToe();
    private TextView playerNameView;
    private TextView winnerNameView;

    public TextView createCell(int index) {
        GradientDrawable border = new GradientDrawable();
        border.setColor(Color.parseColor("#F0ECCF"));
        border.setStroke(1, 0xFF000000);

        TextView cell = new TextView(this);
        cell.setText("");
        cell.setLayoutParams(new LinearLayout.LayoutParams(200, 200));
        cell.setGravity(Gravity.CENTER);
        cell.setBackground(border);
        cell.setClickable(true);
        cell.setOnClickListener(new MoveListener(
                        this.ticTacToe,
                        cell,
                        index,
                        playerNameView,
                        winnerNameView
                )
        );

        return cell;
    }

    public LinearLayout createRow(int[] indexes) {
        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LinearLayout.LayoutParams(600, 200));
        row.setOrientation(LinearLayout.HORIZONTAL);
        Arrays.asList(this.createCell(indexes[0]),
                this.createCell(indexes[1]),
                this.createCell(indexes[2])).forEach(row::addView);

        return row;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.board);
        this.playerNameView = findViewById(R.id.player_name);
        this.winnerNameView = findViewById(R.id.winner_name);
        this.playerNameView.setText(this.ticTacToe.getCurrentPlayer().titleForTurn());
        layout.addView(this.createRow(IntStream.rangeClosed(1, 3).toArray()));
        layout.addView(this.createRow(IntStream.rangeClosed(4, 6).toArray()));
        layout.addView(this.createRow(IntStream.rangeClosed(7, 9).toArray()));
    }
}
