package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Set;

import java.util.List;

public class MatchController extends BaseDAO<Match>{

    private final SetController setController;
    private final BaseDAO<Match> matchDAO;
    private int nextId= 1;

    public MatchController() {
        this.matchDAO = new BaseDAO<>();
        setController = new SetController();
    }

    public List<Match> getMatches() {
     return this.matchDAO.getEntities();
    }

    public void addMatch(Match match) {
        match.setId(this.generateUniqueId());
        this.matchDAO.addEntity(match);
    }

    private int generateUniqueId() {
        return nextId++;
    }

    public void playMatch(Match match) {
        while(!match.hasWinner()){
            Set set= new Set(match.getScoreBoard());
            match.addSet(set);
            this.setController.addSet(set);
            this.setController.playSet(set);
            }
        }
//        this.matchDAO.updateMatch(match);
}





