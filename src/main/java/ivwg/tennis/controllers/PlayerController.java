package ivwg.tennis.controllers;

import ivwg.tennis.database.PlayerDAO;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;

public class PlayerController extends BaseController<Player> {

    private final PlayerDAO playerDAO = new PlayerDAO();

    public Error addPlayer(Player player) {
        Player addedPlayer = this.addEntity(player);
        if (addedPlayer == null) {
            return Error.DUPLICATE_PLAYER;
        }
        return Error.NULL_ERROR;
    }
}

