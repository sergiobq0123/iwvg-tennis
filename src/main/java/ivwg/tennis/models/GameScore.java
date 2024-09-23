package ivwg.tennis.models;

import java.util.List;

public class GameScore extends Score{

    private static final int WINNING_POINTS = 4;
    private int idGameWinner;

    public GameScore(List<Player> players) {
        super(players);
    }

    @Override
    public boolean hasWinner(){
        int score1 = this.getScorePlayer1();
        int score2 = this.getScorePlayer2();
        if (score1 >= WINNING_POINTS && (score1 - score2) >= 2) {
            this.idGameWinner = this.getPlayers().getFirst().getId();
            return true;
        } else
            this.idGameWinner = this.getPlayers().get(1).getId();
        return score2 >= WINNING_POINTS && (score2 - score1) >= 2;
    }


    public void fault(){
        if (!this.getPlayers().getFirst().getService()){
            this.updateScore1();
        }
        else
            this.updateScore2();
    }

    public void updateScore(boolean isPlayer1){
        if(isPlayer1){
            this.updateScore1();
        }
        else{
            this.updateScore2();
        }
    }

    public int getIdGameWinner() {
        return idGameWinner;
    }

    public void setIdGameWinner(int idGameWinner) {
        this.idGameWinner = idGameWinner;
    }
}
