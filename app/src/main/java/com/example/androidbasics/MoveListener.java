package com.example.androidbasics;

import android.view.View;
import android.widget.TextView;

import com.example.androidbasics.domain.Player;
import com.example.androidbasics.domain.TicTacToe;

public class MoveListener implements View.OnClickListener {

    TicTacToe game;
    TextView cell;
    Integer indexOfCell;
    TextView playerNameView;
    TextView winnerNameView;

    public MoveListener(TicTacToe game,
                        TextView cell,
                        Integer indexOfCell,
                        TextView playerNameView,
                        TextView winnerNameView) {
        this.game = game;
        this.cell = cell;
        this.indexOfCell = indexOfCell;
        this.playerNameView = playerNameView;
        this.winnerNameView = winnerNameView;
    }

    @Override
    public void onClick(View view) {
        if (game.isAlreadyPlayed(indexOfCell)) return;

        cell.setText(game.getCurrentPlayer().getSymbol().toString());
        game.play(indexOfCell);
        playerNameView.setText(game.getCurrentPlayer().titleForTurn());

        Player winner = game.winner();
        if (winner != null) {
            winnerNameView.setText(String.format("%s is winner!", winner.getSymbol()));
        }
    }
}
