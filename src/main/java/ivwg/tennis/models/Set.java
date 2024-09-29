package ivwg.tennis.models;

import ivwg.utils.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Set extends Identifier {

    private final List<Game> games;
    private ScoreBoard scoreBoard;

    public Set(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.games = new ArrayList<>();
    }

    public boolean hasWinner() {
        return this.scoreBoard.hasWinner(this.scoreBoard.getSetScore());
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public void setScoreBoard( ScoreBoard scoreBoard ) {
        this.scoreBoard = scoreBoard;
    }
    public void updateSets() {
        this.scoreBoard.updateScoreAfterWin(scoreBoard.getMatchScore(), scoreBoard.getSetScore());
        SetScore setScoreCopy = scoreBoard.getSetScore().copy();
        this.scoreBoard.addSetGamesToView(setScoreCopy);
    }

    public void resetScore() {
        this.scoreBoard.resetScore(this.scoreBoard.getSetScore());
    }

    public int getActualGames() {
        return this.scoreBoard.getActualGames();
    }

    public int getSetResult(int i){
       return this.scoreBoard.getSetResult(i);
    }
}
