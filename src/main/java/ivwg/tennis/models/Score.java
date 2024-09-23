package ivwg.tennis.models;

import java.util.List;

public abstract class Score {

    private int scorePlayer1;
    private int scorePlayer2;
    private int idGameWinner;
    private List<Player> players;

    public Score(List<Player> players) {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
        this.players = players;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }
    public void updateScore1() {
        this.scorePlayer1++;
    }

    public void updateScore2() {
        this.scorePlayer2++;
    }

    public abstract boolean hasWinner();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getIdGameWinner() {
        return idGameWinner;
    }

    public void setIdGameWinner(int idGameWinner) {
        this.idGameWinner = idGameWinner;
    }
}
