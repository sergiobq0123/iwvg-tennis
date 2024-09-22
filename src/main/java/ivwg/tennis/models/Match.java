package ivwg.tennis.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Match {
    private int id;
    private List<Set> sets;
    private List<Player> players;
    private MatchScore matchScore;
    private int numberSets;
    private Date date;


    public Match(int numberSets, List<Player> players) {
        this.id = UUID.randomUUID().hashCode();
        this.numberSets = numberSets;
        this.players = players;
        this.matchScore = new MatchScore();
        this.sets = new ArrayList<>();
        this.date = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(MatchScore matchScore) {
        this.matchScore = matchScore;
    }

    public int getNumberSets() {
        return numberSets;
    }

    public void setNumberSets(int numberSets) {
        this.numberSets = numberSets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match: " +
                "id=" + id +
                "; date=" + date +
                "; setsNumber=" + numberSets +
                "; players = " + players.toString();

    }
}
