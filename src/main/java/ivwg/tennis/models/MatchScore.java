package ivwg.tennis.models;

import java.util.List;

public class MatchScore extends Score{

    private final int numberSets;

    private static final int SETS_3 = 3;
    private static final int WINNING_SETS_3 = 2;

    private static final int SETS_5 = 5;
    private static final int WINNING_SETS_5 = 3;

    public MatchScore(List<Player> players, int numberSets) {
        super(players);
        this.numberSets = numberSets;
    }

    @Override
    public boolean hasWinner(){
        if (numberSets == SETS_3) {
            return checkWinnerForSets(WINNING_SETS_3);
        } else if (numberSets == SETS_5) {
            return checkWinnerForSets(WINNING_SETS_5);
        }
        return false;
    }

    private boolean checkWinnerForSets(int setsToWin) {
        if (this.getScore(0) == setsToWin){
            this.setIdGameWinner(this.getPlayers().getFirst().getId());
            return true;
        }
        else if(this.getScore(1) == setsToWin){
            this.setIdGameWinner(this.getPlayers().get(1).getId());
            return true;
        }
            return false;
    }

    public int getNumberSets() {
        return numberSets;
    }
}
