package com.example.androidbasics.domain;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Symbol symbol;
    private final String name;
    private Set<Integer> moves;

    public Player(Symbol symbol, String name) {
        this.symbol = symbol;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public String titleForTurn() {
        return String.format("%s's turn. %s", this.name, this.symbol);
    }

    public void reset() {
        this.moves = new HashSet<>();
    }
}
