package ivwg.tennis.models;

import ivwg.tennis.types.Action;
import java.util.List;

public class ScoreBoard {

    private SetScore setScore;
    private MatchScore matchScore;
    private GameScore gameScore;
    private List<Player> players;
    private int idServiceTiebreak= -1;

    public ScoreBoard(int numberSets, List<Player> players) {
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


    public void resetScore(Score score){
        score.reset();
    }

    public void updateScore(Score score,int i){
        score.updateScore(i);
    }

    public void updatePointScore(Action action) {
        switch (action) {
            case Action.WIN_PLAYER_1 -> this.updateScore(gameScore,0);
            case Action.WIN_PLAYER_2 -> this.updateScore(gameScore,1);
            default -> throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    public void updateGamesAfterWin(){
        int winnerId =  this.gameScore.getIdGameWinner();
        if (winnerId == this.players.getFirst().getId()){
            this.updateScore(setScore,0);
        } else
            this.updateScore(setScore,1);
    }

    public void updateSetsAfterWin() {
        int winnerId = this.setScore.getIdGameWinner();
        if (winnerId == this.players.getFirst().getId()) {
            this.updateScore(matchScore,0);
        } else
            this.updateScore(matchScore,1);
    }

    public int getService(){
        if (this.players.getFirst().getService()) {
            return this.players.getFirst().getId();
        } else {
            return this.players.get(1).getId();
        }
    }

    public void changeService() {
        if (this.players.getFirst().getService()) {
            this.players.getFirst().setService(false);
            this.players.get(1).setService(true);
        } else {
            this.players.getFirst().setService(true);
            this.players.get(1).setService(false);
        }
    }
    public void changeService(int id) {
        if (this.players.getFirst().getId() == id) {
            this.players.getFirst().setService(false);
            this.players.get(1).setService(true);
        } else {
            this.players.getFirst().setService(true);
            this.players.get(1).setService(false);
        }
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
        if (this.players.getFirst().getService()) {
            this.updateScore(gameScore,1);
        }
        else {
            this.updateScore(gameScore,0);
        }
    }

    public int getIdServiceTiebreak() {
        return idServiceTiebreak;
    }

    public void setIdServiceTiebreak(int idServiceTiebreak) {
        this.idServiceTiebreak = idServiceTiebreak;
    }
}
