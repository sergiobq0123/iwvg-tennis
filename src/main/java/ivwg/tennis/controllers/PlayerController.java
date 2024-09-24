package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;

public class PlayerController extends BaseController<Player> {

    private final BaseDAO<Player> playerDAO;

    public PlayerController() {
        this.playerDAO = new BaseDAO<>();
    }

    public Error addPlayer(Player player) {
        Player addedPlayer = this.addEntity(player);
        if (addedPlayer == null) {
            return Error.DUPLICATE_PLAYER;
        }
        return Error.NULL_ERROR;
    }
}

