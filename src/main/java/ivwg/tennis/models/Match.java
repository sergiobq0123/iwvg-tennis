package ivwg.tennis.models;

import ivwg.utils.Identifier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match extends Identifier {
    private List<Set> sets;
    private List<Player> players;
    private ScoreBoard scoreBoard;
    private int numberSets;
    private Date date;


    public Match(int numberSets, List<Player> players) {
        super();
        this.numberSets = numberSets;
        this.players = players;
        this.scoreBoard = new ScoreBoard(this.numberSets, this.players);
        this.sets = new ArrayList<>();
        this.date = new Date(System.currentTimeMillis());
    }

    public boolean hasWinner(){
        return this.scoreBoard.hasWinner(this.scoreBoard.getMatchScore());
    }

    public Date getDate() {
        return date;
    }

    public void addSet(Set set){
        this.sets.add(set);
    }

    @Override
    public String toString() {
        return "Match: " +
                "id=" + this.getId() +
                "; date=" + date +
                "; setsNumber=" + numberSets +
                "; players = " + players.toString();

    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

}
