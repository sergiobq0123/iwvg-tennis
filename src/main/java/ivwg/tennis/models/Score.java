package ivwg.tennis.models;

import java.util.List;

public abstract class Score {

    private int[] score;

    private int idWinner;
    private final List<Player> players;

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

    public int getIdWinner() {
        return idWinner;
    }

    public void setIdWinner(int idWinner) {
        this.idWinner = idWinner;
    }

    public void reset() {
        this.score[0] = 0;
        this.score[1] = 0;
    }

    protected void setScore(int[] score) {
        this.score = score;
    }
    public int[] getTotalScore() {
        return this.score;
    }
}
