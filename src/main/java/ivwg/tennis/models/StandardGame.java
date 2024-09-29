package ivwg.tennis.models;

public class StandardGame extends Game {
    public StandardGame(ScoreBoard scoreBoard, int setId) {
        super(scoreBoard, setId);
    }

    @Override
    public boolean hasWinner() {
        this.getScoreBoard().setTiebreak(false);
        return super.hasWinner();
    }

    @Override
    public void changeService() {
        this.getScoreBoard().changeService();
    }

    @Override
    public void play(GamePlayerSelector gameSelector) {
        gameSelector.playGame(this);
    }
}
