package ivwg.tennis.controllers;

import ivwg.tennis.models.Game;
import ivwg.tennis.models.GamePlayerSelector;
import ivwg.tennis.models.StandardGame;
import ivwg.tennis.models.TieBreakGame;

public class GameController extends GenericController<Game> implements GamePlayerSelector {

    private final PointController pointController;

    public GameController() {
        pointController = new PointController();
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