package ivwg.tennis.controllers;


import ivwg.tennis.database.GameDAO;
import ivwg.tennis.models.Game;

public class GameController {

    private PointController pointController;
    private GameDAO gameDAO;
    private int nextId= 1;

    public GameController() {
        gameDAO = new GameDAO();
        pointController = new PointController();
    }
    public void addGame(Game game) {
        game.setId(this.generateUniqueId());
        this.gameDAO.addGame(game);
    }

    public void playGame(Game game) {
        game.changeService();
        game.resetScore();
        while(!game.hasWinner()){
            this.pointController.playPoint(game.getScoreBoard());
        }
        game.updateGames();
    }

    private int generateUniqueId() {
        return nextId++;
    }
}
