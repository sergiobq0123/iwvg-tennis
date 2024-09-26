package ivwg.tennis.controllers;

import ivwg.tennis.database.BaseDAO;
import ivwg.tennis.models.Match;
import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;

import java.util.Objects;

public class PlayerController extends BaseController<Player> {

    public PlayerController() {
    }

    public Error addPlayer(Player player) {
        Player addedPlayer = this.addEntity(player);
        if (addedPlayer == null) {
            return Error.DUPLICATE_PLAYER;
        }
        return Error.NULL_ERROR;
    }

    public Player getPlayer(int id){
        return this.getEntity(p -> p.getId() == id);
    }
}