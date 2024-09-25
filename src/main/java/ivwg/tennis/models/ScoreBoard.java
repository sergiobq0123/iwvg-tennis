package ivwg.tennis.models;

import ivwg.tennis.types.Action;
import java.util.List;
import java.util.Random;

public class ScoreBoard {

    private SetScore setScore;
    private MatchScore matchScore;
    private GameScore gameScore;
    private List<Player> players;
    private int service;
    private int serviceTiebreak = -1;

    public ScoreBoard(int numberSets, List<Player> players) {
        Random random = new Random();
        service = random.nextInt(2);
        matchScore = new MatchScore(players, numberSets);
        setScore = new SetScore(players);
        gameScore = new GameScore(players);
        this.players = players;
    }

    public boolean hasWinner(Score score){
     return score.hasWinner();
    }
    public boolean hasWinnerTieBreak(){
        return this.gameScore.hasWinnerTieBreak();
    }

    public void changeService(){
        if(this.serviceTiebreak != -1){
            System.out.println("Cambio raro");
            this.service= this.serviceTiebreak;
            this.serviceTiebreak = -1;
        }
        else {
            this.service = updateService();
        }
    }

    public void resetScore(Score score){
        score.reset();
    }

    public void updateScore(Score score,int i){
        score.updateScore(i);
    }

    public void updateScoreAfterWin(Score updateScore, Score winnerScore){
        int winnerId =  winnerScore.getIdGameWinner();
        if (winnerId == this.players.getFirst().getId()){
            this.updateScore(updateScore,0);
        } else
            this.updateScore(updateScore,1);
    }

    public void updatePointScore(Action action) {
        switch (action) {
            case Action.WIN_PLAYER_1 -> this.updateScore(gameScore,0);
            case Action.WIN_PLAYER_2 -> this.updateScore(gameScore,1);
            default -> throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    public int getService(){
        return this.service;
    }

    public int getActualGames(){
       return this.setScore.getActualGames();
    }

    public SetScore getSetScore() {
        return setScore;
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public void updatePointsFault(){
        this.updateScore(gameScore, this.updateService());
    }

    public void setServiceTiebreak(int serviceTiebreak) {
        this.serviceTiebreak = serviceTiebreak;
    }

    private int updateService(){
        return (this.service+1)%2;
    }
}
