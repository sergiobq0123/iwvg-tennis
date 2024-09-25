package ivwg.tennis.models;

public abstract class Game {

    private int id;
    private ScoreBoard scoreBoard;

    public Game(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }


    public abstract boolean hasWinner();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public void updateGames(){
        this.scoreBoard.updateGamesAfterWin();
    }

    public abstract void changeService();

    public abstract void play(GameSelector gameSelector);

    public void resetScore(){
        this.scoreBoard.resetScore(this.scoreBoard.getGameScore());
    }
}
