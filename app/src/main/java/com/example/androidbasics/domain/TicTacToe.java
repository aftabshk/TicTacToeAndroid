package com.example.androidbasics.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicTacToe {
    private final List<Player> players;
    private Integer currentPlayerIndex;
    private final Set<Set<Integer>> winningMoves;

    public TicTacToe(String player1Name, String player2Name) {
        this.players = Arrays.asList(new Player(Symbol.X, player1Name), new Player(Symbol.O, player2Name));
        this.currentPlayerIndex = 0;
        this.winningMoves = new HashSet<>(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3)),
                new HashSet<>(Arrays.asList(4, 5, 6)),
                new HashSet<>(Arrays.asList(7, 8, 9)),
                new HashSet<>(Arrays.asList(1, 4, 7)),
                new HashSet<>(Arrays.asList(2, 5, 8)),
                new HashSet<>(Arrays.asList(3, 6, 9)),
                new HashSet<>(Arrays.asList(1, 5, 9)),
                new HashSet<>(Arrays.asList(3, 5, 7))
        ));
    }

    public void play(Integer position) {
        if (isAlreadyPlayed(position)) return;

        this.getCurrentPlayer().play(position);
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 2;
    }

    public boolean isAlreadyPlayed(Integer position) {
        Set<Integer> allMoves = Stream.of(
                        this.players.get(0).getMoves(),
                        this.players.get(1).getMoves()
                )
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());

        return allMoves.contains(position);
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    public Player winner() {
        return this.players.stream().reduce(null, (winner, player) -> {
            if (winner != null) return winner;
            if (isWinner(player)) return player;
            return winner;
        });
    }

    public void reset() {
        this.players.forEach(Player::reset);
        this.currentPlayerIndex = 0;
    }

    private boolean isWinner(Player player) {
        Set<Integer> playerMoves = player.getMoves();

        return this.winningMoves.stream().anyMatch(playerMoves::containsAll);
    }
}
