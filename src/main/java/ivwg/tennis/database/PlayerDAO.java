package ivwg.tennis.database;

import ivwg.tennis.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class PlayerDAO {

    private final ArrayList<Player> playerList = new ArrayList<>();

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public Stream<Player> findAll() {
        return playerList.stream();
    }

    public boolean existsByName(String name) {
        return this.findAll()
                .anyMatch(pl -> pl.getName().equals(name));
    }

    public boolean existsById(UUID idPlayer) {
        return this.findAll()
                .anyMatch(pl -> pl.getId() == idPlayer);
    }

    public List<Player> getPlayers() {
        return playerList;
    }

    public Player getPlayer(UUID id) {
        return this.findAll()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
