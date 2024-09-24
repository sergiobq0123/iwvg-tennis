package ivwg.tennis.database;

import ivwg.tennis.models.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameDAO {

    private static final ArrayList<Game> gameList = new ArrayList<>();

    public Stream<Game> findAll() {
        return gameList.stream();
    }

    public void addGame(Game game){gameList.add(game);}

    public List<Game> getGames(){return gameList;}

}
