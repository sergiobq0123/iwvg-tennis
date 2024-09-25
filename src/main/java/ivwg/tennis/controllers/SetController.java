package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Game;
import ivwg.tennis.models.GameFactory;
import ivwg.tennis.models.Set;

public class SetController extends BaseController<Set> {

    private final GameController gameController;
    private final BaseDAO<Set> setDAO;
    private int nextId= 1;
    private final GameFactory gameFactory;

    public SetController() {
        this.gameController = new GameController();
        this.setDAO = new BaseDAO<>();
        this.gameFactory = new GameFactory();
    }

    public void addSet(Set set) {
        set.setId(this.generateUniqueId());
        this.setDAO.addEntity(set);
    }

    public void playSet(Set set){
        set.resetScore();

        while(!set.hasWinner()){
            Game game= gameFactory.createGame(set.getActualGames(),set.getScoreBoard());
            set.addGame(game);
            this.gameController.addGame(game);
            this.gameController.playGame(game);
        }
        set.updateSets();
    }

    private int generateUniqueId() {
        return nextId++;
    }
}
