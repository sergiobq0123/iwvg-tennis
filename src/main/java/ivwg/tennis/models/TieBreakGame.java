package ivwg.tennis.models;


public class TieBreakGame extends Game {

    private static final int CONSECUTIVE_SERVICE = 2;

    int serviceCounter = 0;

    public TieBreakGame(ScoreBoard scoreBoard) {
        super(scoreBoard);
    }

    @Override
    public boolean hasWinner() {
        this.getScoreBoard().setTiebreak(true);
        return super.hasWinner();
    }

    @Override
    public void changeService() {
        this.sumServiceCounter();
        if (serviceCounter == CONSECUTIVE_SERVICE) {
            this.getScoreBoard().changeService();
            resetServiceCounter();
        }
    }

    private void sumServiceCounter() {
        this.serviceCounter ++;
    }

    public int getService() {
        return this.getScoreBoard().getService();
    }

    private void resetServiceCounter() {
        this.serviceCounter = 0;
    }

    public void updateService(int service) {
        this.getScoreBoard().setServiceTiebreak(service);
    }

    @Override
    public void play(GamePlayerSelector gameSelector) {
        gameSelector.playGame(this);
    }

}
