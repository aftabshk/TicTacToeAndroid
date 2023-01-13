package com.example.androidbasics;

import android.view.View;
import android.widget.TextView;

import com.example.androidbasics.domain.TicTacToe;

public class MoveListener implements View.OnClickListener {

    TicTacToe game;
    TextView cell;
    Integer indexOfCell;
    TextView playerNameView;

    public MoveListener(TicTacToe game, TextView cell, Integer indexOfCell, TextView playerNameView) {
        this.game = game;
        this.cell = cell;
        this.indexOfCell = indexOfCell;
        this.playerNameView = playerNameView;
    }

    @Override
    public void onClick(View view) {
        if (game.isAlreadyPlayed(indexOfCell)) return;

        cell.setText(game.getCurrentPlayer().getSymbol().toString());
        game.play(indexOfCell);
        playerNameView.setText(game.getCurrentPlayer().titleForTurn());
    }
}
