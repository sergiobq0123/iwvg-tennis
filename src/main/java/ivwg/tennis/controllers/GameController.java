package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Game;

public class GameController extends BaseDAO<Game> {

    private final PointController pointController;
    private final BaseDAO<Game> gameDAO;
    private int nextId= 1;

    public GameController() {
        gameDAO = new BaseDAO<>();
        pointController = new PointController();
    }
    public void addGame(Game game) {
        game.setId(this.generateUniqueId());
        this.gameDAO.addEntity(game);
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