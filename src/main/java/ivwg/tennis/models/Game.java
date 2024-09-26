package ivwg.tennis.models;

import ivwg.utils.Identifier;

public abstract class Game extends Identifier {

    private final ScoreBoard scoreBoard;
    private int setId;

    Game(ScoreBoard scoreBoard,int setId) {
        super();
        this.scoreBoard = scoreBoard;
        this.setId = setId;
    }

    public abstract boolean hasWinner();

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void updateGames() {
        this.scoreBoard.updateScoreAfterWin(scoreBoard.getSetScore(), scoreBoard.getGameScore());
    }

    public abstract void changeService();

    public abstract void play(GameSelector gameSelector);

    public void resetScore() {
        this.scoreBoard.resetScore(this.scoreBoard.getGameScore());
    }
}
