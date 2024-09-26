package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Set;

import java.util.List;

public class MatchController extends BaseController<Match>{

    private final SetController setController;

    public MatchController() {
        setController = new SetController();
    }

    public void addMatch(Match match) {
        this.addEntity(match);
    }

    public void playMatch(Match match) {
        while(!match.hasWinner()){
            Set set= new Set(match.getScoreBoard(), match.getId());
            match.addSet(set);
            this.setController.addSet(set);
            this.setController.playSet(set);
            }
        this.updateEntity(m -> m.getId() == match.getId(), match);
    }
}





