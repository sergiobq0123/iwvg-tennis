package ivwg.tennis.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Match {
    private int id;
    private List<Set> sets;
    private List<Player> players;
    private ScoreBoard scoreBoard;
    private int numberSets;
    private Date date;
    private int winnerId;


    public Match(int numberSets, List<Player> players) {
        this.numberSets = numberSets;
        this.players = players;
        this.scoreBoard = new ScoreBoard(this.numberSets, this.players);
        this.sets = new ArrayList<>();
        this.date = new Date(System.currentTimeMillis());
    }

    public boolean hasWinner(){
        return this.scoreBoard.hasWinner(this.scoreBoard.getMatchScore());
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

    public void addSet(Set set){
        this.sets.add(set);
    }

    public void addScorePlayer1(){
        this.scoreBoard.addSet1();
    }

    public void addScorePlayer2(){
        this.scoreBoard.addSet2();
    }

    @Override
    public String toString() {
        return "Match: " +
                "id=" + id +
                "; date=" + date +
                "; setsNumber=" + numberSets +
                "; players = " + players.toString();

    }

    public void updateMatch(){
//        this.scoreBoard.updateMatchAfterWin();
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

}
