package ivwg.tennis.models;

import java.util.List;

public class SetScore extends Score {

    private static final int WINNING_POINTS = 6;
    private static final int MINIMUM_LEAD = 2;

    private boolean tieBreak;

    public SetScore(List<Player> players) {
        super(players);
    }

    @Override
    public boolean hasWinner(){
        if (this.getScorePlayer1() == WINNING_POINTS && this.getScorePlayer2() == WINNING_POINTS) {
            this.tieBreak = true;
        }
        if(tieBreak)
           return checkWinnerTieBreak();
        else
           return checkNormalWinner();
    }

    private boolean checkWinnerTieBreak(){
        if(getScorePlayer1() == 7){
            System.out.println("Ganador set player1");
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        }
        else if(getScorePlayer2() == 7){
            System.out.println("Ganador set player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
        return false;
    }

    private boolean checkNormalWinner(){
        if(getScorePlayer1() >= WINNING_POINTS && (getScorePlayer1() - getScorePlayer2()) >= MINIMUM_LEAD){
            System.out.println("Ganador set player1");

            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        }
       else if(getScorePlayer2() >= WINNING_POINTS && (getScorePlayer2() - getScorePlayer1()) >= MINIMUM_LEAD){
            System.out.println("Ganador set player2");
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
       return false;
    }

    public int getActualGames(){
        return this.getScorePlayer1() + this.getScorePlayer2();
    }
}
