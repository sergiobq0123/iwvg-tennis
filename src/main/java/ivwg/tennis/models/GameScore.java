package ivwg.tennis.models;

import java.util.List;

public class GameScore extends Score{

    private static final int WINNING_POINTS = 4;
    private static final int TIEBREAK_WINNING_POINTS = 6;

    public GameScore(List<Player> players) {
        super(players);
    }

    @Override
    public boolean hasWinner(){
        int score1 = this.getScore(0);
        int score2 = this.getScore(1);
        if (score1 >= WINNING_POINTS && (score1 - score2) >= 2) {
            System.out.println("Ganador game player1");
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if(score2 >= WINNING_POINTS && (score2 - score1) >= 2) {
            System.out.println("Ganador game player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }
    public boolean hasWinnerTieBreak(){
        int score1 = this.getScore(0);
        int score2 = this.getScore(1);
        if (score1 >= TIEBREAK_WINNING_POINTS && (score1 - score2) >= 2) {
            System.out.println("Ganador Tiebreak player1");
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        } else if(score2 >= TIEBREAK_WINNING_POINTS && (score2 - score1) >= 2) {
            System.out.println("Ganador tiebreak player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }
}
