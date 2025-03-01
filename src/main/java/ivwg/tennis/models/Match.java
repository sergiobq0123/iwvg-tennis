package ivwg.tennis.models;

import ivwg.utils.Identifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match extends Identifier {
    private final List<Set> sets;
    private final List<Player> players;
    private final ScoreBoard scoreBoard;
    private final Date date;


    public Match(int numberSets, List<Player> players) {
        super();
        this.players = players;
        this.scoreBoard = new ScoreBoard(numberSets, this.players);
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

    public List<Player> getPlayers() {
        return players;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public List<Set> getSets() {
        return sets;
    }

    @Override
    public String toString() {
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(this.date);

        return String.format("MatchId :%d; date :%s; player1:%s; player2:%s; sets: %s",
                this.getId(),formattedDate, this.getPlayers().get(0), this.getPlayers().get(1),
                this.getSets().size());
    }
}
