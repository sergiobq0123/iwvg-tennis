package ivwg.tennis.controllers;


import ivwg.tennis.database.GameDAO;
import ivwg.tennis.models.Game;

public class GameController {

    private PointController pointController;
    private GameDAO gameDAO;
    private int nextId= 1;

    public GameController() {
        this.gameDAO = new GameDAO();
    }
    public void addGame(Game game) {
        game.setId(this.generateUniqueId());
        this.gameDAO.addGame(game);
    }

    public void playGame(Game game) {
        this.pointController = new PointController(game.getScoreBoard());
        while(!game.hasWinner()){
            this.pointController.playPoint();
        }
        game.updateGames();
    }

    private int generateUniqueId() {
        return nextId++;
    }
}
