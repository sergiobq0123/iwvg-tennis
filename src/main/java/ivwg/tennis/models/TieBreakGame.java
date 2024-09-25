package ivwg.tennis.models;


public class TieBreakGame extends Game{

    int serviceCounter = 0;

    public TieBreakGame(ScoreBoard scoreBoard) {
        super(scoreBoard);
    }

    @Override
    public boolean hasWinner() {
        return this.getScoreBoard().hasWinnerTieBreak();
    }

    @Override
    public void changeService() {
        serviceCounter++;
        if(serviceCounter == 2){
            System.out.println("CAMBIO");
            this.getScoreBoard().changeService();
            this.serviceCounter = 0;
        }
    }
    public int getService(){
       return this.getScoreBoard().getService();
    }
    public void updateService(int service){
        this.getScoreBoard().setServiceTiebreak(service);
    }
    @Override
    public void play(GameSelector gameSelector) {
        gameSelector.playGame(this);
    }

}
