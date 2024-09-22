package ivwg.tennis.controllers;

import ivwg.tennis.database.PlayerDAO;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;

import java.util.List;
import java.util.UUID;

public class PlayerController {

    private PlayerDAO playerDAO;

    public PlayerController() {
        this.playerDAO = new PlayerDAO();
    }

    public Error addPlayer(Player player) {
        if (!playerDAO.existsByName(player.getName())) {
            playerDAO.addPlayer(player);
            return Error.NULL_ERROR;
        }
        return Error.DUPLICATE_PLAYER;
    }

    public List<Player> getPlayers() {
        return this.playerDAO.getPlayers();
    }

    public Player getPlayer(UUID id) {
        return this.playerDAO.getPlayer(id);
    }

    public Error playerExists(UUID id) {
        if (playerDAO.existsById(id)) {
            return Error.NULL_ERROR;
        }
        return Error.PLAYER_NOT_FOUND;
    }
}

