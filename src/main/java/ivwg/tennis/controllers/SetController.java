package ivwg.tennis.controllers;

import ivwg.tennis.database.SetDAO;
import ivwg.tennis.models.Game;
import ivwg.tennis.models.Set;

public class SetController {

    private GameController gameController;
    private SetDAO setDAO;
    private int nextId= 1;

    public SetController() {
        this.gameController = new GameController();
        this.setDAO = new SetDAO();
    }

    public void addSet(Set set) {
        set.setId(this.generateUniqueId());
        this.setDAO.addSet(set);
    }

    public void playSet(Set set){
        set.getScoreBoard().resetSetScore();
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
