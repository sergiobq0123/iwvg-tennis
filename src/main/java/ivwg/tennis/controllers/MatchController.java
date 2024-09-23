package ivwg.tennis.controllers;

import ivwg.tennis.database.MatchDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Set;
import ivwg.tennis.types.Error;

import java.util.List;
import java.util.Random;

public class MatchController {

    private SetController setController;
    private MatchDAO matchDAO;
    private int nextId= 1;

    public MatchController() {
        this.matchDAO = new MatchDAO();
        setController = new SetController();
    }

    public List<Match> getMatches() {
     return this.matchDAO.getMatches();
    }

    public void addMatch(Match match) {
        match.setId(this.generateUniqueId());
        this.matchDAO.addMatch(match);
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





