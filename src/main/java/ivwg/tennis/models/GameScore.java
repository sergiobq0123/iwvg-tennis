package ivwg.tennis.models;

import java.util.List;

public class GameScore extends Score {

    private static final int WINNING_POINTS = 4;
    private static final int TIEBREAK_WINNING_POINTS = 6;
    private boolean isTieBreak = false;

    public GameScore(List<Player> players) {
        super(players);
    }

    @Override
    public boolean hasWinner() {
        return hasWinnerWithPoints(isTieBreak ? TIEBREAK_WINNING_POINTS : WINNING_POINTS);
    }

    private boolean hasWinnerWithPoints(int winningPoints) {
        int score1 = this.getScore(0);
        int score2 = this.getScore(1);
        if (score1 >= winningPoints && (score1 - score2) >= 2) {
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if (score2 >= winningPoints && (score2 - score1) >= 2) {
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }

    public void setTieBreak(boolean tieBreak) {
        isTieBreak = tieBreak;
    }
}
