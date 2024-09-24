package ivwg.tennis.models;

public class Game {

    private int id;
    private ScoreBoard scoreBoard;

    public Game(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public boolean hasWinner() {
        return this.scoreBoard.hasGameWinner();
    }

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

    public void changeService(){
        this.scoreBoard.changeService();
    }


}
