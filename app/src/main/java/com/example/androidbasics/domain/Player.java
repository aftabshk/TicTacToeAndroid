package com.example.androidbasics.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Symbol symbol;
    private final Set<Integer> moves;

    public Player(Symbol symbol) {
        this.symbol = symbol;
        this.moves = new HashSet<>();
    }

    public void play(Integer position) {
        this.moves.add(position);
    }

    public Set<Integer> getMoves() {
        return moves;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
