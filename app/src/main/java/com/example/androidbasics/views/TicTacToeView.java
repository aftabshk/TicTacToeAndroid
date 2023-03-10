package com.example.androidbasics.views;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbasics.R;
import com.example.androidbasics.domain.TicTacToe;
import com.example.androidbasics.listeners.MoveListener;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TicTacToeView extends AppCompatActivity {

    private TicTacToe ticTacToe;
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
        String player1Name = "";
        String player2Name = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player1Name = extras.getString("player1Name");
            player2Name = extras.getString("player2Name");
        }
        this.ticTacToe = new TicTacToe(player1Name, player2Name);
        setContentView(R.layout.board);
        LinearLayout layout = findViewById(R.id.board);
        this.playerNameView = findViewById(R.id.player_name);
        this.winnerNameView = findViewById(R.id.winner_name);
        this.playerNameView.setText(this.ticTacToe.getCurrentPlayer().titleForTurn());
        layout.addView(this.createRow(IntStream.rangeClosed(1, 3).toArray()));
        layout.addView(this.createRow(IntStream.rangeClosed(4, 6).toArray()));
        layout.addView(this.createRow(IntStream.rangeClosed(7, 9).toArray()));

        findViewById(R.id.reset).setOnClickListener((button) -> {
            this.ticTacToe.reset();
            this.resetLayout(layout);
            this.playerNameView.setText(this.ticTacToe.getCurrentPlayer().titleForTurn());
            this.winnerNameView.setText("");
        });
    }

    private void resetLayout(LinearLayout layout) {
        int childCount = layout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childAt = layout.getChildAt(i);
            if (childAt instanceof LinearLayout) {
                resetLayout((LinearLayout) childAt);
            }
            if (childAt instanceof TextView) {
                resetTextView((TextView) childAt);
            }
        }
    }

    private void resetTextView(TextView view) {
        view.setText("");
    }
}
