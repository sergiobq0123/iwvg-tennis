package ivwg.tennis.database;

import ivwg.tennis.models.Match;
import ivwg.tennis.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MatchDAO {

    private final ArrayList<Match> matchList = new ArrayList<>();

    public Stream<Match> findAll() {
        return matchList.stream();
    }

    public void addMatch(Match match){
        matchList.add(match);
    }

    public List<Match> getMatches(){
        return matchList;
    }
}
