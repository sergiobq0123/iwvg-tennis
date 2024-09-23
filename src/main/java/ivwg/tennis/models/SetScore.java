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
            checkWinnerTieBreak();
        else
            checkNormalWinner();
        return  false;
    }

    private boolean checkWinnerTieBreak(){
        return (getScorePlayer1() == 7 || getScorePlayer2() == 7 );

    }

    private boolean checkNormalWinner(){
        return getScorePlayer1() >= WINNING_POINTS && (getScorePlayer1() - getScorePlayer2()) >= MINIMUM_LEAD
        || getScorePlayer2() >= WINNING_POINTS && (getScorePlayer2() - getScorePlayer1()) >= MINIMUM_LEAD;
    }


}
