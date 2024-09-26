package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Game;
import ivwg.tennis.models.GameSelector;
import ivwg.tennis.models.StandardGame;
import ivwg.tennis.models.TieBreakGame;

public class GameController extends BaseController<Game> implements GameSelector {

    private final PointController pointController;

    public GameController() {
        pointController = new PointController();
    }
    public void addGame(Game game) {
        this.addEntity(game);
    }

    public void playGame(Game game) {
        game.resetScore();
        game.play(this);
        game.updateGames();
    }

    @Override
    public void playGame(StandardGame standardGame) {
        standardGame.changeService();
        while(!standardGame.hasWinner()){
            this.pointController.playPoint(standardGame.getScoreBoard());
        }
    }

    @Override
    public void playGame(TieBreakGame tiebreakGame) {
        tiebreakGame.changeService();
        int firstService = tiebreakGame.getService();
        while(!tiebreakGame.hasWinner()){
            tiebreakGame.changeService();
            this.pointController.playPoint(tiebreakGame.getScoreBoard());
        }
        tiebreakGame.updateService(firstService);
    }

}