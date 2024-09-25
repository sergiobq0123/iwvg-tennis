package ivwg.tennis.models;

import java.util.ArrayList;
import java.util.List;

public class Set {

    private int id;
    private List<Game> games;
    private ScoreBoard scoreBoard;

    public Set(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.games = new ArrayList<>();
    }

    public boolean hasWinner() {
        return this.scoreBoard.hasWinner(this.scoreBoard.getSetScore());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addGame(Game game){
        this.games.add(game);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void updateSets(){
        this.scoreBoard.updateScoreAfterWin(scoreBoard.getMatchScore(), scoreBoard.getSetScore());
    }

    public void resetScore(){
        this.scoreBoard.resetScore(this.scoreBoard.getSetScore());
    }
    public int getActualGames(){
        return this.scoreBoard.getActualGames();
    }
}
