package com.example.androidbasics.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicTacToe {
    private final List<Player> players;
    private Integer currentPlayerIndex;

    public TicTacToe() {
        this.players = Arrays.asList(new Player(Symbol.X), new Player(Symbol.O));
        this.currentPlayerIndex = 0;
    }

    public void play(Integer position) {
        if (isAlreadyPlayed(position)) return;

        this.getCurrentPlayer().play(position);
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 2;
    }

    public boolean isAlreadyPlayed(Integer position) {
        Set<Integer> allMoves = Stream.of(this.players.get(0).getMoves(), this.players.get(1).getMoves())
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());

        return allMoves.contains(position);
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }
}
