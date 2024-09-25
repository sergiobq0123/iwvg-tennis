package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Game;
import ivwg.tennis.models.GameSelector;
import ivwg.tennis.models.StandardGame;
import ivwg.tennis.models.TieBreakGame;

public class GameController extends BaseDAO<Game> implements GameSelector {

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
        game.play(this);
    }

    private int generateUniqueId() {
        return nextId++;
    }

    @Override
    public void playGame(StandardGame standardGame) {
        standardGame.resetScore();
        standardGame.changeService();
        while(!standardGame.hasWinner()){
            this.pointController.playPoint(standardGame.getScoreBoard());
        }
        standardGame.updateGames();
    }

    @Override
    public void playGame(TieBreakGame tiebreakGame) {
        System.out.println("Soy Tiebreak");
        tiebreakGame.resetScore();
        tiebreakGame.changeService();
        int firstService = tiebreakGame.getService();
        while(!tiebreakGame.hasWinner()){
            tiebreakGame.changeService();
            this.pointController.playPoint(tiebreakGame.getScoreBoard());
        }
        tiebreakGame.updateService(firstService);
        tiebreakGame.updateGames();
    }

}