package ivwg.tennis.models;

import java.util.List;

public abstract class Score {

    private int[] score;

    private int idGameWinner;
    private List<Player> players;

    public Score(List<Player> players) {
        this.score = new int[2];
        this.players = players;
    }

    public int getScore(int i) {
        return this.score[i];
    }

    public void updateScore(int i) {
        this.score[i]++;
    }

    public abstract boolean hasWinner();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getIdWinner() {
        return idGameWinner;
    }

    public void setIdGameWinner(int idGameWinner) {
        this.idGameWinner = idGameWinner;
    }

    public void reset() {
        this.score[0] = 0;
        this.score[1] = 0;
    }
}
