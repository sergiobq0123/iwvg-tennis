package ivwg.tennis.models;

import java.util.List;

public class ScoreBoard {

    private SetScore setScore;
    private MatchScore matchScore;
    private GameScore gameScore;
    private List<Player> players;

    public ScoreBoard(int numberSets, List<Player> players) {
        matchScore= new MatchScore(players,numberSets);
        setScore = new SetScore(players);
        gameScore= new GameScore(players);
        this.players= players;
    }

    public boolean hasSetWinner(){
      return this.setScore.hasWinner();
    }

    public boolean hasMatchWinner(){
      return this.matchScore.hasWinner();
    }
    public boolean hasGameWinner(){
      return this.gameScore.hasWinner();
    }

    public void addSet1(){
        this.matchScore.updateScore1();
    }
    public void addSet2(){
        this.matchScore.updateScore1();
    }

    public void updatePointScore(boolean isFault, boolean isPlayer1){
        if(isFault){
            this.gameScore.fault();
        } else  {
            this.gameScore.updateScore(isPlayer1);

        }
    }

    public void resetGameScore(){
        this.gameScore.reset();
    }

    public void resetSetScore(){
        this.setScore.reset();
    }

    public void updateGamesAfterWin(){
        int winnerId =  this.gameScore.getIdGameWinner();
        if (winnerId == this.players.getFirst().getId()){
            this.setScore.updateScore1();
        }
        else
            this.setScore.updateScore2();
    }

    public void updateSetsAfterWin(){
        int winnerId =  this.setScore.getIdGameWinner();
        if (winnerId == this.players.getFirst().getId()){
            this.matchScore.updateScore1();
        }
        else
            this.matchScore.updateScore2();
    }
    public void changeService(){
        if (this.players.getFirst().getService()){
            this.players.getFirst().setService(false);
            this.players.get(1).setService(true);
        }
        else{
            this.players.getFirst().setService(true);
            this.players.get(1).setService(false);
        }
    }

}
