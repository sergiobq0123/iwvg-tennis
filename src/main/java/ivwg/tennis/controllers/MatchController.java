package ivwg.tennis.controllers;

import ivwg.tennis.models.Match;
import ivwg.tennis.models.Set;

public class MatchController extends GenericController<Match> {

    private final SetController setController;

    public MatchController(SetController setController) {
        this.setController = setController;
    }

    public void addMatch(Match match) {
        this.addEntity(match);
    }

    public void playMatch(Match match) {
        while(!match.hasWinner()){
            Set set= new Set(match.getScoreBoard());
            match.addSet(set);
            this.setController.addSet(set);
            this.setController.playSet(set);
            }
        this.updateEntity(m -> m.getId() == match.getId(), match);
    }

    public double getMatchWinPercentage(int id){
        double totalMatches= this.findAllEntitiesFilter(
                match -> match.getPlayers().getFirst().getId() == id || match.getPlayers().get(1).getId() == id
        ).size();
        double winMatches= this.findAllEntitiesFilter(
                match -> match.getScoreBoard().getMatchScore().getIdWinner() == id
        ).size();
        return (totalMatches > 0) ? (winMatches * 100.0) / totalMatches : 0;

    }
}





