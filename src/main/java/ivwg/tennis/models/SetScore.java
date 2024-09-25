package ivwg.tennis.models;

import java.util.List;

public class SetScore extends Score {

    private static final int WINNING_POINTS = 6;
    private static final int WINNING_POINTS_TIE_BREAK = 7;
    private static final int MINIMUM_LEAD = 2;

    private boolean tieBreak;

    public SetScore(List<Player> players) {
        super(players);
    }

    @Override
    public boolean hasWinner() {
        if (this.getScore(0) == WINNING_POINTS && this.getScore(1) == WINNING_POINTS) {
            this.tieBreak = true;
        }
        if (tieBreak)
            return checkWinnerTieBreak();
        else
            return checkNormalWinner();
    }

    private boolean checkWinnerTieBreak() {
        if (getScore(0) == WINNING_POINTS_TIE_BREAK) {
            System.out.println("Ganador set player1");
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if (getScore(1) == WINNING_POINTS_TIE_BREAK) {
            System.out.println("Ganador set player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }

    private boolean checkNormalWinner() {
        if (getScore(0) >= WINNING_POINTS && (getScore(0) - getScore(1)) >= MINIMUM_LEAD) {
            System.out.println("Ganador set player1");
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if (getScore(1) >= WINNING_POINTS && (getScore(1) - getScore(0)) >= MINIMUM_LEAD) {
            System.out.println("Ganador set player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }

    public int getActualGames() {
        return this.getScore(0) + this.getScore(1);
    }
}
