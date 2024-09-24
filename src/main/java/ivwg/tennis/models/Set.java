package ivwg.tennis.models;

import java.util.ArrayList;
import java.util.List;

public class Set {

    private int id;
    private List<Game> games;
    private ScoreBoard scoreBoard;
    private int winnerId;

    public Set(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        this.games = new ArrayList<>();
    }

    public boolean hasWinner() {
        return this.scoreBoard.hasSetWinner();
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
        this.scoreBoard.updateSetsAfterWin();
    }
}
