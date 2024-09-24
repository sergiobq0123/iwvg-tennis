package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Game;
import ivwg.tennis.models.Set;

public class SetController extends BaseController<Set> {

    private final GameController gameController;
    private final BaseDAO<Set> setDAO;
    private int nextId= 1;

    public SetController() {
        this.gameController = new GameController();
        this.setDAO = new BaseDAO<>();
    }

    public void addSet(Set set) {
        set.setId(this.generateUniqueId());
        this.setDAO.addEntity(set);
    }

    public void playSet(Set set){
        set.resetScore();
        while(!set.hasWinner()){
            Game game= new Game(set.getScoreBoard());
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
