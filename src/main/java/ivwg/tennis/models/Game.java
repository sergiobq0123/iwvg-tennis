package ivwg.tennis.models;

import ivwg.utils.Identifier;

public abstract class Game extends Identifier {

    private final ScoreBoard scoreBoard;

    Game(ScoreBoard scoreBoard,int setId) {
        super();
        this.scoreBoard = scoreBoard;
    }

    public boolean hasWinner(){
        return this.getScoreBoard().hasWinner(this.getScoreBoard().getGameScore());
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void updateGames() {
        this.scoreBoard.updateScoreAfterWin(scoreBoard.getSetScore(), scoreBoard.getGameScore());
    }

    public abstract void changeService();

    public abstract void play(GamePlayerSelector gameSelector);

    public void resetScore() {
        this.scoreBoard.resetScore(this.scoreBoard.getGameScore());
    }
}
