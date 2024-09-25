package ivwg.tennis.models;


public class StandardGame extends Game {
    public StandardGame(ScoreBoard scoreBoard) {
        super(scoreBoard);
    }

    @Override
    public boolean hasWinner() {
        return this.getScoreBoard().hasWinner(this.getScoreBoard().getGameScore());
    }

    @Override
    public void changeService() {
        this.getScoreBoard().changeService();
    }

    @Override
    public void play(GameSelector gameSelector) {
        gameSelector.playGame(this);
    }
}
