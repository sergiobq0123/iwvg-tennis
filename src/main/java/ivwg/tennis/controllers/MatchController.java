package ivwg.tennis.controllers;

import ivwg.tennis.database.MatchDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.types.Error;

import java.util.List;

public class MatchController {

    private MatchDAO matchDAO;

    public MatchController() {
        this.matchDAO = new MatchDAO();
    }

    public List<Match> getMatches() {
     return this.matchDAO.getMatches();
    }

    public void addMatch(Match match) {
        this.matchDAO.addMatch(match);
    }
}
