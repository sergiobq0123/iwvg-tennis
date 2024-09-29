package ivwg.tennis.controllers;

import ivwg.tennis.models.Player;
import ivwg.tennis.types.Error;

public class PlayerController extends GenericController<Player> {

    public PlayerController() {
    }

    public Error addPlayer(Player player) {
        Player addedPlayer = this.addEntity(player);
        if (addedPlayer == null) {
            return Error.DUPLICATE_PLAYER;
        }
        return Error.NULL_ERROR;
    }
}