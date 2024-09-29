package ivwg.tennis.models;

import java.util.List;

public class SetScore extends Score {

    private static final int WINNING_POINTS = 6;
    private static final int WINNING_POINTS_TIE_BREAK = 7;
    private static final int MINIMUM_LEAD = 2;

    public SetScore(List<Player> players) {
        super(players);
    }

    private SetScore(List<Player> players, int[] score, int idGameWinner) {
        super(players);
        this.setScore(score);
        this.setIdWinner(idGameWinner);
    }

    @Override
    public boolean hasWinner() {
        int scorePlayer1 = getScore(0);
        int scorePlayer2 = getScore(1);
        if (checkWinPlayer(scorePlayer1,scorePlayer2)) {
            this.setIdWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if (checkWinPlayer(scorePlayer2,scorePlayer1)) {
            this.setIdWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }

    private boolean checkWinPlayer(int scorePlayer1, int scorePlayer2) {
       return scorePlayer1 == WINNING_POINTS_TIE_BREAK ||scorePlayer1 >= WINNING_POINTS && (scorePlayer1 - scorePlayer2) >= MINIMUM_LEAD;
    }

    public int getActualGames() {
        return this.getScore(0) + this.getScore(1);
    }

    public SetScore copy(){
        int[] scoreCopy = this.getTotalScore().clone();
        return new SetScore(this.getPlayers(), scoreCopy, this.getIdWinner());
    }

}
